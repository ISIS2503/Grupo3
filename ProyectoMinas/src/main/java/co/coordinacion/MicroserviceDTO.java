/*
 * The MIT License
 *
 * Copyright 2017 Universidad De Los Andes - Departamento de Ingeniería de Sistemas.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package co.coordinacion;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author e.galvis10
 */

@XmlRootElement
public class MicroserviceDTO implements Serializable {
   public static final String TYPE_DYNAMIC="DYNAMIC";
    public static final String TYPE_DYNAMIC_SEQUENTIAL="DYNAMIC_SEQUENTIAL";
    public static final String TYPE_PERMANENT="PERMANENT";
    public static final String TYPE_STATIC="STATIC";
    public static final String STATUS_UP="UP";
    public static final String STATUS_DOWN="Down";
 
    private String appName;
    private String microserviceName;
    private String microserviceId;
    private String server;
    private Integer port;
    private String path;
    private String type;
    private String status;
 
    public MicroserviceDTO() {
    }
 
    public MicroserviceDTO(String appName, String microserviceName, String microserviceId, String server, Integer port, String path, String type, String status) {
        this.appName = appName;
        this.microserviceName = microserviceName;
        this.microserviceId = microserviceId;
        this.server = server;
        this.port = port;
        this.path = path;
        this.type = type;
        this.status = status;
    }
 
    public String getAppName() {
        return appName;
    }
 
    public void setAppName(String appName) {
        this.appName = appName;
    }
 
    public String getMicroserviceName() {
        return microserviceName;
    }
 
    public void setMicroserviceName(String microserviceName) {
        this.microserviceName = microserviceName;
    }
 
    public String getMicroserviceId() {
        return microserviceId;
    }
 
    public void setMicroserviceId(String microserviceId) {
        this.microserviceId = microserviceId;
    }
 
    public String getServer() {
        return server;
    }
 
    public void setServer(String server) {
        this.server = server;
    }
 
    public Integer getPort() {
        return port;
    }
 
    public void setPort(Integer port) {
        this.port = port;
    }
 
    public String getPath() {
        return path;
    }
 
    public void setPath(String path) {
        this.path = path;
    }
 
    public String getType() {
        return type;
    }
 
    public void setType(String type) {
        this.type = type;
    }
 
    public String getStatus() {
        return status;
    }
 
    public void setStatus(String status) {
        this.status = status;
    }
 
  
}
