package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void add(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Car> listCars() {
        return sessionFactory.getCurrentSession().createQuery("from Car").getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deleteAllCars() {
        List<Car> cars = listCars();
        for (Car car : cars) {
            sessionFactory.getCurrentSession().delete(car);
        }
    }
}
