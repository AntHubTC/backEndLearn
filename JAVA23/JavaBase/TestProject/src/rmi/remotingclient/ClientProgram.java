package rmi.remotingclient;

import rmi.modle.PersonEntity;
import rmi.service.PersonService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * RMI客户端
 */
public class ClientProgram {
    public static void main(String[] args){
        Remote lookup = null;
        try {
            lookup = Naming.lookup("rmi://127.0.0.1:6600/PersonService");
            PersonService personService = (PersonService) lookup;
            List<PersonEntity> list = personService.getList();
            for (PersonEntity person : list) {
                System.out.println("ID:"+person.getId()+" Age:"+person.getAge()+" Name:"+person.getName());
            }
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
