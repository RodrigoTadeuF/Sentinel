package br.com.fiap.sentinel;

public class GenerateId {

    private static Long id = 0l;

    public static long generateId() {
        id ++;
        return id;
    }
}
