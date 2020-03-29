package controller;

import model.LoginModel;

public class LoginController {

		public boolean singUp(String email, String password) {
			
			if(email != null && email.length() > 0 && password != null && password.length() > 0) {
				LoginModel loginModel = new LoginModel(email, password);
				loginModel.registerUser(loginModel);
				return true;
			}else {
				return false;
			}
		}
}
