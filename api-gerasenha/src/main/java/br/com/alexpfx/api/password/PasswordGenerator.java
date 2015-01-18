package br.com.alexpfx.api.password;

/**
 * Created by alexandre on 13/01/15.
 */
public interface PasswordGenerator <O extends PasswordOptions> {


    String generatePassword (O options);

}
