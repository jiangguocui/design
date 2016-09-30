package com.design.observer;
//报纸接口
public interface INewsPaper {
    //添加订阅者
    void RegisterSubscriber(ISubScribe subScribe);
    //取消订阅
    void RemoveSubScriber(ISubScribe subScribe);
    //发送报纸
    void SendPaper();
}
