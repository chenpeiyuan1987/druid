/*
 * Copyright 1999-2018 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.druid.sql.dialect.phoenix.ast;

import com.alibaba.druid.sql.ast.SQLStatementImpl;
import com.alibaba.druid.sql.dialect.db2.ast.DB2Object;
import com.alibaba.druid.sql.dialect.db2.visitor.DB2ASTVisitor;
import com.alibaba.druid.sql.dialect.phoenix.visitor.PhoenixASTVisitor;
import com.alibaba.druid.sql.visitor.SQLASTVisitor;
import com.alibaba.druid.util.JdbcConstants;

/**
 * Created by wenshao on 16/9/14.
 */
public abstract class PhoenixStatementImpl extends SQLStatementImpl implements PhoenixObject {

    public PhoenixStatementImpl() {
        super(JdbcConstants.PHOENIX);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor instanceof PhoenixASTVisitor) {
            accept0((PhoenixASTVisitor) visitor);
            return;
        }

        super.accept0(visitor);
    }

    @Override
    public abstract void accept0(PhoenixASTVisitor visitor);
}
