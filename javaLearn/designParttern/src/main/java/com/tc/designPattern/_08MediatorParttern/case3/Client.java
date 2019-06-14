package com.tc.designPattern._08MediatorParttern.case3;

public class Client {
    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();
        ConcreteColleague1 concreteColleague1 = new ConcreteColleague1(mediator);
        ConcreteColleague2 concreteColleague2 = new ConcreteColleague2(mediator);
        mediator.setC1(concreteColleague1);
        mediator.setC2(concreteColleague2);

        concreteColleague1.depMethod1();
        concreteColleague2.depMethod2();
    }
}
