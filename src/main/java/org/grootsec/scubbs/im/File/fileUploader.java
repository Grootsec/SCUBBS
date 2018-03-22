package org.grootsec.scubbs.im.File;

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

            filename = getSHA1String(tempFile);
            String filepath = "/file/" + filename;

        }catch (IOException e) {

        }
        return Response.status(400).build();
    }
}
