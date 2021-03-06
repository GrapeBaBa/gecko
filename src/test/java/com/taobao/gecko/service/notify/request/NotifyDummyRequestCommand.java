/*
 * (C) 2007-2012 Alibaba Group Holding Limited.
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
package com.taobao.gecko.service.notify.request;

import com.taobao.gecko.core.command.kernel.DummyRequestCommand;
import com.taobao.gecko.core.util.OpaqueGenerator;
import com.taobao.gecko.service.notify.OpCode;


/**
 * Dummy��������ڲ���
 * 
 * @author aoqiong
 * 
 */
public class NotifyDummyRequestCommand extends NotifyRequestCommand implements DummyRequestCommand {
    static final long serialVersionUID = 234985443249230L;
    private String dummy;


    public String getDummy() {
        return this.dummy;
    }


    public void setDummy(final String dummy) {
        this.dummy = dummy;
    }


    public NotifyDummyRequestCommand(final OpCode opCode) {
        super(opCode);

    }


    public NotifyDummyRequestCommand(final String dummy) {
        this.opaque = OpaqueGenerator.getNextOpaque();
        this.opCode = OpCode.DUMMY;
        this.dummy = dummy;
    }


    public void decodeContent() {
        if (this.header != null) {
            this.dummy = new String(this.header);
        }
    }


    public void encodeContent() {
        if (this.dummy != null) {
            this.setHeader(this.dummy.getBytes());
        }

    }

}