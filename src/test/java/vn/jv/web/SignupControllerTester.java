package vn.jv.web;

import javax.servlet.ServletContext;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultHandler;

import vn.jv.BaseTester;

/**
 * Test actions in SignupController
 * 
 * @author hunglevn@outlook.com
 *
 */
public class SignupControllerTester extends BaseTester {
	@Test
	public void testSingupRequestPage () {
		RequestBuilder requestBuilder = new RequestBuilder() {
			
			public MockHttpServletRequest buildRequest(ServletContext servletContext) {
				MockHttpServletRequest request = new MockHttpServletRequest(servletContext, "GET", "/sec/sign_up.jv");
				return request;
			}
		};
		try {
			ResultActions resultAction = mockMVC.perform(requestBuilder);
			ResultHandler handler = new ResultHandler() {
				
				public void handle(MvcResult result) throws Exception {
					System.out.println(result.getModelAndView());
				}
			};
			MvcResult result = resultAction.andDo(handler).andReturn();
			Assert.assertEquals("Failed", "security/sign_up", result.getModelAndView().getViewName());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

