package ee.itcollege.borderproject.setup;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import ee.itcollege.borderproject.dao.GuardDao;
import ee.itcollege.borderproject.model.Guard;

@Component
public class GuardDataInserter {
	
	public static final String SYSTEM_USER = "system";

	@Resource
	GuardDao guardDao;
	
	public void insertGuards(){
		if (!hasTestDataBeenInserted()) {
			guardDao.save(testGuard1());
			guardDao.save(testGuard2());
			guardDao.save(testGuard3());
			guardDao.save(testGuard4());
			guardDao.save(testGuard5());
			guardDao.save(testGuard6());
		}
	}
	
	private Guard testGuard1(){
		Guard guard = new Guard();
		guard.setAddress("Metsa 13, Kullikajaka linn, Ida-Virumaa, Eesti");
		guard.setEmail("peoloom33@hot.ee");
		guard.setFirstName("Jürno");
		guard.setGender(0);
		guard.setLastName("Gustavson");
		guard.setPhoneNumber("57575755");
		guard.setSocialSecurityNumber("39108023344");
		guard.setSoldiersCode("PV123");
		
		return guard;
	}
	
	private Guard testGuard2(){
		Guard guard = new Guard();
		guard.setAddress("Lemmingu 93, Rondirimaka küla, Jõetalu vald, Viljandimaa, Eesti");
		guard.setEmail("tiitr@gmail.com");
		guard.setFirstName("Tiit");
		guard.setGender(0);
		guard.setLastName("Raginaator");
		guard.setPhoneNumber("57575755");
		guard.setSocialSecurityNumber("38503195900");
		guard.setSoldiersCode("PV_664");
		
		return guard;
	}
	
	private Guard testGuard3(){
		Guard guard = new Guard();
		guard.setAddress("Narva tn 9-44, Kohtla-Järve, Ida-Virumaa, Eesti");
		guard.setEmail("valts@mail.ee");
		guard.setFirstName("Valdur");
		guard.setGender(0);
		guard.setLastName("Joomakajakas");
		guard.setPhoneNumber("6785522");
		guard.setSocialSecurityNumber("38912129642");
		guard.setSoldiersCode("PV_302");
		guard.setComment("Noomitus tööpostil alkoholi tarbimise eest");
		
		return guard;
	}
	
	private Guard testGuard4(){
		Guard guard = new Guard();
		guard.setAddress("Jõe 1-5, Verivarda linn, Pärnumaa, Eesti");
		guard.setEmail("jaanussimyrk@hotmail.com");
		guard.setFirstName("Jaan");
		guard.setGender(0);
		guard.setLastName("Ussimürk");
		guard.setPhoneNumber("54218954");
		guard.setSocialSecurityNumber("38808086265");
		guard.setSoldiersCode("PV_522");
		guard.setComment("Kiitused (5) piiri ületavate metsloomade juhendamise eest");
		
		return guard;
	}
	
	private Guard testGuard5(){
		Guard guard = new Guard();
		guard.setAddress("Jaavakohvi 103, Murati, Võrumaa, Eesti");
		guard.setEmail("pets@bmw.ee");
		guard.setFirstName("Peeter");
		guard.setGender(0);
		guard.setLastName("Kuuseriis");
		guard.setPhoneNumber("52051256");
		guard.setSocialSecurityNumber("39011035623");
		guard.setSoldiersCode("PV_098");
		guard.setComment("Noomitused (3) pideva kiiruse ületamise eest ametialase autoga töö ajal");
		
		return guard;
	}
	
	private Guard testGuard6(){
		Guard guard = new Guard();
		guard.setAddress("Metsa 13, Kullikajaka linn, Ida-Virumaa, Eesti");
		guard.setEmail("urrkiisuke@hot.ee");
		guard.setFirstName("Mairit");
		guard.setGender(1);
		guard.setLastName("Magistral");
		guard.setPhoneNumber("57575756");
		guard.setSocialSecurityNumber("49006125623");
		guard.setSoldiersCode("KR_001");
		guard.setComment("Noomitused (3) pideva kiiruse ületamise eest ametialase autoga töö ajal");
		
		return guard;
	}
	
	private boolean hasTestDataBeenInserted() {
		for (Guard guard : guardDao.getAll()) {
			if (SYSTEM_USER.equals(guard.getCreator()))
				return true;
		}
		
		return false;
			
	}
	
}
