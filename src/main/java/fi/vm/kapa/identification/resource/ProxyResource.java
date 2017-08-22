/**
 * The MIT License
 * Copyright (c) 2015 Population Register Centre
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
package fi.vm.kapa.identification.resource;

import fi.vm.kapa.identification.dto.ProxyMessageDTO;
import fi.vm.kapa.identification.dto.SessionAttributeDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Map;

public interface ProxyResource {

    @GET
    @Path("/idp/init")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    ProxyMessageDTO fromIdPInitSession(@QueryParam("r") String relyingParty,
                                       @QueryParam("uid") String uid,
                                       @QueryParam("key") String key,
                                       @QueryParam("reqauthmethods") String authMethodReqStr,
                                       @QueryParam("tag") String logTag)
            throws WebApplicationException;

    @GET
    @Path("/idp/session")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    ProxyMessageDTO fromIdPRequestSession(@QueryParam("tid") String tokenId,
                                          @QueryParam("pid") String phaseId,
                                          @QueryParam("tag") String logTag)
            throws WebApplicationException;

    @GET
    @Path("/idp/purge")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    ProxyMessageDTO fromIdPPurgeSession(@QueryParam("tid") String tokenId,
                                        @QueryParam("pid") String phaseId,
                                        @QueryParam("tag") String logTag)
            throws WebApplicationException;

    @GET
    @Path("/idp/attributes")
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    SessionAttributeDTO getSessionAttributes(@QueryParam("uid") String uid,
                                             @QueryParam("authmethodoid") String authMethodOid,
                                             @QueryParam("relyingparty") String relyingParty,
                                             @QueryParam("tokenRequired") boolean tokenRequired,
                                             @QueryParam("authnRequestId") String authnRequestId)
            throws WebApplicationException;

    @POST
    @Path("/sp")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
    ProxyMessageDTO fromSPBuildSessionPost(@QueryParam("tid") String tokenId,
                                           @QueryParam("pid") String phaseId,
                                           @QueryParam("tag") String logTag,
                                           Map<String,String> spSessionData)
            throws WebApplicationException;
}
