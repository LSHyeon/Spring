package di_annotation;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;


//LgTV 객체 생성하고, 스피커도 주입해서 TV사용

@Component("lgtv")
public class LgTV implements TV {
	@Resource(name = "apple")
	private Speaker speaker;
	private int price;
	
	public LgTV() {
		System.out.println(">> LgTV 객체 생성");
	}

	@Override
	public void powerOn() {
		System.out.println("LgTV - 전원 ON");
		
	}

	@Override
	public void powerOff() {
		System.out.println("LgTV - 전원 OFF");
		
	}

	@Override
	public void volumnUp() {
		System.out.println("LgTV - 소리 크게");
		speaker.volumnUp();
	}

	@Override
	public void volumnDown() {
		System.out.println("LgTV - 소리 작게");
		speaker.volumnDown();
	}
	
	//-------------------------------------------
	public void initMethod() {
		System.out.println("LgTV - initMethod() 실행");
	}
		
	public void destroyMethod() {
		System.out.println("LgTV - destroyMethod() 실행");
	}

	public Speaker getSpeaker() {
		return speaker;
	}

	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "LgTV [speaker=" + speaker + ", price=" + price + "]";
	}
	
	
}
