package com.tva.icd.dbtests;

import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.tva.icd.configuration.ApplicationConfig;
import com.tva.icd.model.Chapter;
import com.tva.icd.service.ChapterService;
import com.tva.icd.service.ChapterServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
@WebAppConfiguration
public class DbTests {
  
  @Autowired
  @Qualifier("chapterService")
  ChapterService chapterService;

  @Test
  public void testChapterNumbers() {
    assertThat(chapterService, instanceOf(ChapterServiceImpl.class));
    
    List<Chapter> chaptersList = chapterService.getAllChapters("en");
    assertEquals(21, chaptersList.size());
  }

}
