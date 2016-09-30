package com.design.status;

public class Main {
public static void main(String[] args) {
    Context context =new Context();
    State tvStartState = new TVStartState();
    State tvStopState = new TVStopState();
    context.setState(tvStartState);
    context.doAction();
    
    context.setState(tvStopState);
    tvStopState.doAction();

}
}
