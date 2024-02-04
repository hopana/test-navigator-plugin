package com.staszkox.test.navigator.files.finders;

import com.intellij.psi.PsiClass;
import com.staszkox.test.navigator.configuration.TestNavigatorConfig;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 查找给定源文件类的测试类
 */
public class TestFileFinder extends FileFinder {

	public static TestFileFinder forClass(PsiClass sourceClass) {
		return new TestFileFinder(sourceClass);
	}

	private TestFileFinder(PsiClass sourceClass) {
		super(sourceClass);
	}

	@Override
	protected List<String> getFileNamesForSearch() {
		TestNavigatorConfig configuration = TestNavigatorConfig.getInstance();
		List<String> prefixesOrSuffixes = configuration != null ? configuration.getPrefixesOrSuffixes() : Collections.emptyList();

		String qualifiedClassName = getBaseClass().getQualifiedName();
		if (StringUtils.isBlank(qualifiedClassName)) {
			return Collections.emptyList();
		}

        return prefixesOrSuffixes.stream()
                    .collect(ArrayList::new, (l, e) -> {}, ArrayList::addAll);
    }
}
