import models.Dao;
import md5.hash;
import models.MonAn;
import models.HangHoa;
import models.Nuoc;
import models.User;

import java.util.ArrayList;
import java.util.List;

import md5.hash;
public class t {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user = new User();
		hash md5hashing = new hash();
		Dao dao = new Dao();
		String tk = md5hashing.md5hashing("bo");
		String mk = md5hashing.md5hashing("bo123");
		dao.updateMKUser(mk, tk);		
	}
}
