package co.yedam.app;

import org.springframework.stereotype.Component;

@Component
public class AppleSpeaker implements Speaker {

	@Override
	public void volumeUp() {
		System.out.println("AppleSpeaker Volume Up!");

	}

	@Override
	public void volumeDown() {
		System.out.println("AppleSpeaker Volume Down!");

	}

}
