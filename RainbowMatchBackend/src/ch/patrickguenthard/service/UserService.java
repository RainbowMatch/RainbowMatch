package ch.patrickguenthard.service;

import java.util.List;

import javax.ejb.Remote;

import ch.patrickguenthard.entity.User;
import ch.patrickguenthard.exceptions.UnsupportedException;
import ch.patrickguenthard.exceptions.UserException;

public interface UserService {
    public void addUser(User user) throws UnsupportedException;
    public List<User> searchAllUser();
    /**
     * checkUser(user: user): int
     *
     * checks if user exists and password is correct.
     * throws UserNotFoundException if user doesn't exist
     * throws IncorrectLoginException if password doesn't match username
     */
    public Long checkUser(User user) throws UserException;
}
