package growthook.org.bamgang.members.service;

import growthook.org.bamgang.members.repository.*;
import growthook.org.bamgang.trail.repository.TrailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    private final DataFinishedWalkRepository finishedWalkRepository;

    private final DataPickedWalkRepository dataPickedWalkRepository;

    private final TrailRepository trailRepository;

    private final DataFinishedDestintationRepository dataFinishedDestintationRepository;

    private final SearchWordRepository searchWordRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository, DataFinishedWalkRepository finishedWalkRepository, DataPickedWalkRepository dataPickedWalkRepository, TrailRepository trailRepository, DataFinishedDestintationRepository dataFinishedDestintationRepository, SearchWordRepository searchWordRepository) {
        this.finishedWalkRepository = finishedWalkRepository;
        this.dataPickedWalkRepository = dataPickedWalkRepository;
        this.memberRepository = memberRepository;
        this.trailRepository = trailRepository;
        this.dataFinishedDestintationRepository = dataFinishedDestintationRepository;
        this.searchWordRepository = searchWordRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository,finishedWalkRepository, dataPickedWalkRepository,trailRepository,dataFinishedDestintationRepository, searchWordRepository);
    }
}