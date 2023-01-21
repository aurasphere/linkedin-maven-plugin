package co.aurasphere.maven.plugins.linkedin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import com.echobox.api.linkedin.client.DefaultLinkedInClient;
import com.echobox.api.linkedin.connection.v2.ShareConnection;
import com.echobox.api.linkedin.types.ShareText;
import com.echobox.api.linkedin.types.request.ShareRequestBody;
import com.echobox.api.linkedin.types.urn.URN;

@Mojo(name = "post", defaultPhase = LifecyclePhase.COMPILE)
public class LinkedinMojo extends AbstractMojo {

	@Parameter(required = true, property = "linkedinAccessToken")
	private String linkedinAccessToken;

	@Parameter(required = true, property = "linkedinUserId")
	private String linkedinUserId;

	@Parameter(required = true, property = "linkedinMessage")
	private String message;

	public void execute() throws MojoExecutionException {
		getLog().info("Posting to LinkedIn the following message: " + message);

		// Post to LinkedIn
		try {
			DefaultLinkedInClient client = new DefaultLinkedInClient(linkedinAccessToken);
			ShareConnection shareConnection = new ShareConnection(client);
			ShareRequestBody shareRequestBody = new ShareRequestBody(new URN("urn:li:person:" + linkedinUserId));
			ShareText shareText = new ShareText();
			shareText.setText(message);
			shareRequestBody.setText(shareText);
			shareConnection.postShare(shareRequestBody);
		} catch (Exception e) {
			throw new MojoExecutionException("Error while connecting to LinkedIn", e);
		}
	}
}