package hiber.service;

import hiber.dao.UserDao;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Transactional
    @Override
    public void deleteAllUsers() {
        userDao.deleteAllUsers();
    }

    @Override
    public User findUser(String model, int series) {
        return userDao.findUser(model, series);
    }

}
