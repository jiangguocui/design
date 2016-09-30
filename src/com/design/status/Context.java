package com.design.status;
//能改基于内在对象来改变自身的行为
public class Context implements State {
    private State state;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public void doAction() {
      this.state.doAction();
        
    }
}
