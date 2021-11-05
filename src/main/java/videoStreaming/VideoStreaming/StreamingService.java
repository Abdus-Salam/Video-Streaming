package videoStreaming.VideoStreaming;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;



@Service
public class StreamingService {
	private static final String FORMAT = "classpath:videos/1.mp4";
	
	@Autowired
	public ResourceLoader resourceLoader;
	
	public Mono<Resource> getVideo(String title){
		return Mono.fromSupplier(()-> resourceLoader.getResource(String.format(FORMAT, title)));
	}
}
