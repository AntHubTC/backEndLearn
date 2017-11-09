package rmi.serviceImpl;

import rmi.modle.PersonEntity;
import rmi.service.PersonService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.util.List;

//此为远程对象的实现类，需继承UnicastRemoteObject
public class PersonServiceImpl extends UnicastRemoteObject implements PersonService {

    public PersonServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public List<PersonEntity> getList() throws RemoteException {
        System.out.println("Get Person Start!");
        List<PersonEntity> personEntities = new LinkedList<PersonEntity>();

        PersonEntity person1 = new PersonEntity();
        person1.setId(1);
        person1.setAge(18);
        person1.setName("张三");

        PersonEntity person2 = new PersonEntity();
        person2.setId(2);
        person2.setAge(22);
        person2.setName("李四");

        personEntities.add(person1);
        personEntities.add(person2);

        return personEntities;
    }
}
