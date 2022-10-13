import org.springframework.boot.configurationmetadata.ConfigurationMetadataRepositoryJsonBuilder;
import java.io.ByteArrayInputStream;

public class ConfigurationMetadataRepositoryJsonBuilderFuzzer {
    
    public static void fuzzerTestOneInput(byte[] data) {
        
        try { 
            ConfigurationMetadataRepositoryJsonBuilder.create(new ByteArrayInputStream(data));
        } catch (Exception e) { }
    } 
}
