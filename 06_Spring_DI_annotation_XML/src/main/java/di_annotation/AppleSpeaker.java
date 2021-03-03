package di_annotation;


public class AppleSpeaker implements Speaker {
	public AppleSpeaker() {
		System.out.println(">> AppleSpeaker 생성");
	}
	
	@Override
	public void volumnUp() {
		System.out.println(">> AppleSpeaker 소리 크게");
	}
	
	@Override
	public void volumnDown() {
		System.out.println(">> AppleSpeaker 소리 작게");
	}
}
