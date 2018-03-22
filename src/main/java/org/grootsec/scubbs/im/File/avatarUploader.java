package org.grootsec.scubbs.im.File;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import net.coobird.thumbnailator.Thumbnails;
import net.minidev.json.JSONObject;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.stereotype.Component;

import static org.grootsec.scubbs.im.File.getFileSHA1.getSHA1String;

@Component
@Path("/avatarupload")
public class avatarUploader {
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Response upload(@FormDataParam("file") InputStream fis,
                           @FormDataParam("file") FormDataContentDisposition fileDisposition) {
        try {
            String filename = RandomStringUtils.randomAlphanumeric(32);
            File tempFile = File.createTempFile(filename, "");
            tempFile.deleteOnExit();
            OutputStream outputStream = new FileOutputStream(tempFile);
            IOUtils.copy(fis, outputStream);
            outputStream.close();
            String filetype = checkEXIF(tempFile);

            if (filetype.equals("0")) {
                JSONObject errorMsg = new JSONObject();
                errorMsg.put("code", 0);
                errorMsg.put("Msg", "不支持的文件格式");
                return Response.status(400).entity(errorMsg).build();
            } else if (filetype.equals("-1")) {
                return Response.status(400).entity(unknownError()).build();
            }

            filename = getSHA1String(tempFile);
            String filepath = "/file/" + filename + "." + filetype;

            JSONObject response = new JSONObject();
            response.put("code", 1);
            response.put("filename", filename);
            response.put("filetype", filetype);
            response.put("filepath", "/file/pic/" + filename + "." + filetype);
            response.put("thumbnailpath", "/file/pic/thumbnail" + filename + "." + filetype);

            if (!copyFile(tempFile, filepath)) {
                return Response.status(400).entity(unknownError()).build();
            }

            if (!cutImage(filename, filetype)) {
                return Response.status(400).entity(unknownError()).build();
            }
            final boolean delete = tempFile.delete();
            return Response.status(200).entity(response).build();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return Response.status(400).build();
    }

    private String checkEXIF(File tempFile) {
        String filetype = "-1";
        try {
            Metadata metadata = ImageMetadataReader.readMetadata(tempFile);
            for (Directory directory : metadata.getDirectories()) {
                for (Tag tag : directory.getTags()) {
                    if (tag.getTagName().equals("Expected File Name Extension")) {
                        filetype = tag.getDescription();
                    }
                    System.out.println(tag.getTagName() + " | " + tag.getDescription() + " | " + tag.getTagType());
                }
            }
        } catch (ImageProcessingException e) {
            if (e.getMessage().equals("File format could not be determined")) {
                return "0";
            }
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filetype;
    }

    private boolean copyFile(File tempfile, String filepath) {
        try {
            java.nio.file.Path source = Paths.get(tempfile.getPath());
            java.nio.file.Path destination = Paths.get(filepath);

            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private boolean cutImage(String filename, String filetype) {
        String filepath = "/file/" + filename + "." + filetype;
        String thumbnailpath = "/file/thumbnail/" + filename + "." + filetype;
        try {
            Thumbnails.of(filepath)
                    .size(200, 200)
                    .toFile(thumbnailpath);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private JSONObject unknownError() {
        JSONObject errorMsg = new JSONObject();
        errorMsg.put("code", 0);
        errorMsg.put("Msg", "未知错误");
        return errorMsg;
    }
}
