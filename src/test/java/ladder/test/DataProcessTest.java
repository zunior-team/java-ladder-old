package ladder.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

import ladder.domain.BranchLine;
import ladder.domain.BranchLineManager;
import ladder.domain.DataProcess;

public class DataProcessTest {
	ArrayList<BranchLine> branchLines;
	BranchLine branchLine;
	List<String> names;
	BranchLineManager branchLineManager;

	@Test
	public void testCheckFlag() {
		names = Arrays.asList("pobipobi", "gram");
		assertEquals(true, DataProcess.checkFlag(names));
	}

	@Test
	public void testCheckNamesLength() {
		names = Arrays.asList("pobipobi", "gram");
		assertEquals(false, DataProcess.checkNamesLength(names));
	}

	@Test
	public void testCheckNameLength() {
		names = Arrays.asList("pobipobi", "gram");
		assertEquals(1, DataProcess.checkNamesLength(names, 0, 0));
		assertEquals(0, DataProcess.checkNamesLength(names, 1, 0));
	}

	@Test
	public void testCheckBranch() {
		branchLine = new BranchLine();
		branchLine.add(true);
		branchLine.add(false);
		branchLines = new ArrayList<>();
		branchLines.add(branchLine);
		branchLineManager = new BranchLineManager(branchLines);

		assertEquals("-----", DataProcess.checkBranch(0, 0, branchLineManager));
		assertEquals("     ", DataProcess.checkBranch(0, 1, branchLineManager));
	}

	@Test
	public void testGetQuarter() {
		assertEquals(true, DataProcess.getQuarter(5));
		assertEquals(false, DataProcess.getQuarter(3));
	}

}
