package chaptor.lambdaExpression.classMemberAndLocalVariable.useClassMember;

import chaptor.BasicExample;

public class UsingThisExample extends BasicExample {
    @Override
    public void run() {
        UsingThis usingThis = new UsingThis();
        UsingThis.Inner inner = usingThis.new Inner();
        inner.method();
    }
}
