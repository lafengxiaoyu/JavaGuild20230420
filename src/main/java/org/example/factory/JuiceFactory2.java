package org.example.factory;

class JuiceFactory2 {
    static public IJuice createJuice(String name) throws Exception {
        IJuice iJuice = (IJuice) Class.forName("org.example.factory." + name).newInstance();
        return iJuice;
    }
}
