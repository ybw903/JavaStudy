package chaptor.lambdaExpression.classMemberAndLocalVariable.useClassMember;

import chaptor.BasicTest;

public class UsingThisExample extends BasicTest {
    @Override
    public void run() {
        UsingThis usingThis = new UsingThis();
        UsingThis.Inner inner = usingThis.new Inner();
        inner.method();
    }
}
