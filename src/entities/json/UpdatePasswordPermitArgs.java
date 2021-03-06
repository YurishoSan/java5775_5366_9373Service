/**
 * 
 */
package entities.json;

import entities.Password;
import entities.enums.Permit;

/**
 * Class used to pass arguments in DatabaseService and API-DB.
 *
 */
public class UpdatePasswordPermitArgs
{
	public Password oldPassword;
	public String newPassword;
	
	public Permit permit;
	/**
	 * 
	 */
	public UpdatePasswordPermitArgs()
	{
		super();
	}
	
	/**
	 * @param oldPassword
	 * @param newPassword
	 * @param permit
	 */
	public UpdatePasswordPermitArgs(Password oldPassword, String newPassword,
			Permit permit)
	{
		super();
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
		this.permit = permit;
	}
	
	
}
