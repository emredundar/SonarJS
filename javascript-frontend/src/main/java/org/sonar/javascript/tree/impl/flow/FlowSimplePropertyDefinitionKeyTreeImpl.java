/*
 * SonarQube JavaScript Plugin
 * Copyright (C) 2011-2021 SonarSource SA
 * mailto:info AT sonarsource DOT com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonar.javascript.tree.impl.flow;

import com.google.common.collect.Iterators;
import java.util.Iterator;
import javax.annotation.Nullable;
import org.sonar.javascript.tree.impl.JavaScriptTree;
import org.sonar.plugins.javascript.api.tree.Tree;
import org.sonar.plugins.javascript.api.tree.flow.FlowSimplePropertyDefinitionKeyTree;
import org.sonar.plugins.javascript.api.tree.lexical.SyntaxToken;
import org.sonar.plugins.javascript.api.visitors.DoubleDispatchVisitor;

public class FlowSimplePropertyDefinitionKeyTreeImpl extends JavaScriptTree implements FlowSimplePropertyDefinitionKeyTree {
  private final SyntaxToken nameToken;
  private final SyntaxToken queryToken;

  public FlowSimplePropertyDefinitionKeyTreeImpl(SyntaxToken nameToken, SyntaxToken queryToken) {
    this.nameToken = nameToken;
    this.queryToken = queryToken;
  }

  @Override
  public Kind getKind() {
    return Kind.FLOW_SIMPLE_PROPERTY_DEFINITION_KEY;
  }

  @Override
  public SyntaxToken nameToken() {
    return nameToken;
  }

  @Nullable
  @Override
  public SyntaxToken queryToken() {
    return queryToken;
  }

  @Override
  public Iterator<Tree> childrenIterator() {
    return Iterators.forArray(nameToken, queryToken);
  }

  @Override
  public void accept(DoubleDispatchVisitor visitor) {
    visitor.visitFlowPropertyTypeKey(this);
  }
}
