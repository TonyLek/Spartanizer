package org.spartan.refactoring.wring;

import static org.eclipse.jdt.core.dom.InfixExpression.Operator.TIMES;
import static org.spartan.utils.Utils.in;

import java.util.List;

import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.InfixExpression;
import org.eclipse.jdt.core.dom.InfixExpression.Operator;
import org.spartan.refactoring.utils.ExpressionComparator;

/**
 * A {@link Wring} that sorts the arguments of a {@link Operator#PLUS}
 * expression. Extra care is taken to leave intact the use of
 * {@link Operator#PLUS} for the concatenation of {@link String}s.
 *
 * @author Yossi Gil
 * @since 2015-07-17
 */
public final class InfixSortMultiplication extends Wring.InfixSorting {
  @Override boolean sort(final List<Expression> e) {
    return ExpressionComparator.MULTIPLICATION.sort(e);
  }
  @Override boolean scopeIncludes(final InfixExpression e) {
    return in(e.getOperator(), TIMES);
  }
}