package config;

public class PageFactoryManager {
    private PageFactoryManager() {
    }

    public static <TPage> TPage get(Class<TPage> pageClass) {
        TPage page = null;
        try {
            page = pageClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return page;
    }
}
