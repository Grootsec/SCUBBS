package org.grootsec.scubbs.im.File;

import net.minidev.json.JSONObject;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.*;

import static org.grootsec.scubbs.im.File.getFileSHA1.getSHA1String;

@Component
@Path("/upload")
public class fileUploader {
    private static String rootpath = "/file/";

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

            filename = getSHA1String(tempFile) + "_" + fileDisposition.getFileName();
            String filepath = rootpath + filename;

            if (!copyFile(tempFile, filepath)) {
                return Response.status(400).entity(unknownError()).build();
            }

            JSONObject response = new JSONObject();
            response.put("code", 1);
            response.put("filename", filename);
            response.put("filepath", "/file/" + filename);

            tempFile.delete();
            return Response.status(200).entity(response).build();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return Response.status(400).build();
    }

    private boolean copyFile(File tempfile, String filepath) {
        if (FileCopyer.copyFile(tempfile, filepath)) return true;
        return false;
    }

    private JSONObject unknownError() {
        JSONObject errorMsg = new JSONObject();
        errorMsg.put("code", 0);
        errorMsg.put("Msg", "未知错误");
        return errorMsg;
    }
}
