package ladder.test;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;
import ladder.domain.BranchLine;

public class BranchLineTest {

	private BranchLine branchLine;

	@Before
	public void setup() {
		branchLine = new BranchLine();
		branchLine.add(true);
	}

	@Test
	public void testAdd() {
		branchLine.add(false);
		assertThat(branchLine.getPoint(1), is(false));
	}

	@Test
	public void testCheck() {
		assertThat(branchLine.check(0, 5), is(true));
		assertThat(branchLine.check(0, 2), is(false));
		assertThat(branchLine.check(1, 5), is(false));
	}

	@Test
	public void testGetPoint() {
		assertThat(branchLine.getPoint(0), is(true));
	}

	@Test
	public void testGetLength() {
		assertThat(branchLine.getLength(), is(1));
	}

}
