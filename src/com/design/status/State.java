package com.design.status;

public interface State {
    //此方法需要被不同的具体状态类以及环境类实现
    void doAction();
}
