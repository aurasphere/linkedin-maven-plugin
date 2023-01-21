package co.aurasphere.maven.plugins.linkedin;

import org.apache.maven.plugin.MojoExecutionException;
import org.junit.Test;
import org.mockito.internal.util.reflection.Whitebox;

public class LinkedinMojoTest {

	private LinkedinMojo linkedinMojo = new LinkedinMojo();

	@Test(expected = MojoExecutionException.class)
	public void testWithWrongLinkedinCredentials() throws MojoExecutionException {
		// Mocks the internal state.
		Whitebox.setInternalState(linkedinMojo, "linkedinAccessToken", "a");
		Whitebox.setInternalState(linkedinMojo, "linkedinUserId", "b");

		// Executes the plugin.
		linkedinMojo.execute();
	}

}