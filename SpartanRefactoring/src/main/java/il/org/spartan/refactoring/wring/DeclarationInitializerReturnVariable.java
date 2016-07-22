package il.org.spartan.refactoring.wring;

import static il.org.spartan.refactoring.utils.Funcs.*;
import il.org.spartan.refactoring.preferences.*;
import il.org.spartan.refactoring.utils.*;

import org.eclipse.jdt.core.dom.*;
import org.eclipse.jdt.core.dom.rewrite.*;
import org.eclipse.text.edits.*;

/**
 * A {@link Wring} to convert <code>int a = 3;
 * return a;</code> into <code>return a;</code>
 * https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op1.html
 *
 * @author Yossi Gil
 * @since 2015-08-07
 */
<<<<<<< HEAD
public final class DeclarationInitializerReturnVariable extends Wring.VariableDeclarationFragementAndStatement implements
    Kind.InlineVariable {
  @Override ASTRewrite go(final ASTRewrite r, final VariableDeclarationFragment f, final SimpleName n,
      final Expression initializer, final Statement nextStatement, final TextEditGroup g) {
    if (initializer == null || hasAnnotation(f))
=======
public final class DeclarationInitializerReturnVariable extends Wring.VariableDeclarationFragementAndStatement {
  @Override ASTRewrite go(final ASTRewrite r, final VariableDeclarationFragment f, final SimpleName n, final Expression initializer, final Statement nextStatement,
      final TextEditGroup g) {
    if (initializer == null || hasAnnotation(f) || initializer instanceof ArrayInitializer)
>>>>>>> 30a65bd02c737642fc7ca540229ce59683abc546
      return null;
    final ReturnStatement s = asReturnStatement(nextStatement);
    if (s == null)
      return null;
    final Expression returnValue = extract.expression(s);
    if (returnValue == null || !same(n, returnValue))
      return null;
    eliminate(f, r, g);
    r.replace(s, Subject.operand(initializer).toReturn(), g);
    return r;
  }
  @Override String description(final VariableDeclarationFragment f) {
    return "Eliminate temporary " + f.getName() + " and return its value";
  }
}