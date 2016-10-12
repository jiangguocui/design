package com.utils;
/**
 * 单例枚举型实现
 * <p>Title: Module Information         </p>
 * <p>Description: Function Description </p>
 * <p>Copyright: Copyright (c) 2016     </p>
 * <p>Company: ND Co., Ltd.       </p>
 * <p>Create Time: 2016年10月12日           </p>
 * @author Administrator
 * <p>Update Time:                      </p>
 * <p>Updater:                          </p>
 * <p>Update Comments:                  </p>
 */
public enum SimpleSingleton {
    INSTANCE;
    public void doSomething() {
        System.out.println("单例");
    }
    
    public static void main(String[] args) {
        SimpleSingleton.INSTANCE.doSomething();
    }
}
