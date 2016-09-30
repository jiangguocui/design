package com.design.observer;

import java.util.ArrayList;
import java.util.List;

//人民日报
public class PeopleNewsPaper implements INewsPaper {
    // 订阅者
    private List<ISubScribe> subList = new ArrayList<ISubScribe>();

    // 添加订阅者
    @Override
    public void RegisterSubscriber(ISubScribe subScribe) {
        subList.add(subScribe);
    }

    // 取消订阅
    @Override
    public void RemoveSubScriber(ISubScribe subScribe) {
        if (subList.indexOf(subScribe) >= 0) {
            subList.remove(subScribe);
        }

    }

    // 发报纸
    @Override
    public void SendPaper() {
        for (ISubScribe iSubScribe : subList) {
            iSubScribe.hasNewPaper();
        }

    }

}
