//package deepforce.forum.provider;
//
//
//import com.google.auth.Credentials;
//import com.google.auth.oauth2.ServiceAccountCredentials;
//import com.google.cloud.storage.*;
//import deepforce.forum.exception.CustomizeErrorCode;
//import deepforce.forum.exception.CustomizeException;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import java.net.URL;
//import java.util.UUID;
//import java.util.concurrent.TimeUnit;
//
//@Service
//@Slf4j
//@SuppressWarnings("static-access")
//public class GoogleCloudProvider {
//
//    private Storage storage = null;
//    private Credentials credentials = null;
//
//    @Value("${google.cloud.project.id}")
//    private String projectId;
//
//    @Value("${google.cloud.bucketname}")
//    private String bucketName;
//
//    @Value("${google.cloud.client.id}")
//    private String clientId;
//
//    @Value("${google.cloud.email.id}")
//    private String clientEmailId;
//
//    @Value("${google.cloud.privateKeyId}")
//    private String privateKeyId;
//
//    @Value("${google.cloud.privateKey}")
//    private String privateKey;
//
//    /**
//     * This method sets the storage credentials for the default storage object.
//     */
//    private void setDefaultStorageCredentials() {
//        try {
//            credentials = ServiceAccountCredentials.fromPkcs8(clientId, clientEmailId, privateKey, privateKeyId, null);
//            storage = StorageOptions.newBuilder()
//                    .setCredentials(credentials)
//                    .setProjectId(projectId).build().getService();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    public String upload(byte[] fileStream, String mimeType, String fileName) {
//
//        String generatedFileName;
//        String[] filePaths = fileName.split("\\.");
//        if (filePaths.length > 1) {
//            generatedFileName = UUID.randomUUID().toString() + "." + filePaths[filePaths.length - 1];
//        } else {
//            return null;
//        }
//
//
//        try {
//            setDefaultStorageCredentials();
//            BlobInfo blobInfo = BlobInfo.newBuilder(bucketName, generatedFileName).setContentType(mimeType).build();
//            storage.create(blobInfo, fileStream);
//
//
//            Blob blob = storage.get(bucketName).get(generatedFileName);
//            String blobName = blob.getName();
//            URL url = storage.signUrl(BlobInfo.newBuilder(bucketName, blobName).build(), 7, TimeUnit.DAYS, Storage.SignUrlOption.withV4Signature());
//
//            if (url != null) {
//                return url.toString();
//            }
//            return null;
//        } catch (Throwable e) {
//            log.error("upload error,{}", fileName, e);
//            throw new CustomizeException(CustomizeErrorCode.FILE_UPLOAD_FAIL);
//        }
//    }
//}
