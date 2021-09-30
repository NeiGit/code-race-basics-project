package animals;

import util.IOUtil;

import static util.IOUtil.print;

public abstract class Animal {
    protected final String name;
    protected final boolean speaker;
    protected final int amountOfExpressions;

    public Animal(String name, boolean speaker, int amountOfExpressions) {
        this.name = name;
        this.speaker = speaker;
        this.amountOfExpressions = amountOfExpressions;
    }

    public void express() {
        String expression = "";
        for (int i = 0; i < amountOfExpressions; i ++) {
            expression += this.expression() + " ";
        }

        if (speaker) {
            print(String.format("%s: Hola! Me llamo %s, digo %s y estoy %s", name, name, expression, movement()));
        } else {
            print(String.format("%s: digo %s y estoy %s", name, expression, movement()));
        }
    }

    public void breathe() {
        IOUtil.print("breathing....");
    }

    protected abstract String expression();
    protected abstract String movement();
}
