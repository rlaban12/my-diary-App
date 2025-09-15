# 벡엔드 트러블슈팅

| ID  | 내용                                                                          | 이유                                                                                                        | 해결 방법                                                                                                  | 날짜          |
|-----|-----------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------|-------------|
| BE1 | 'DiaryRepositoryImpl.java' 에서 'private final JPAQueryFactory factory;' 부분 에러 | 'JPAQueryFactory'에 Bean 주입이 안되었기 때문                                                                       | 'QueryDslConfig.java'에 '@Configuration' 추가                                                             | 2025-09-12  | 
| BE2 |        벡엔드 bootRun 실행시 'BeanInstantiationException' 실행 | 'EmailVe ificationRepository.java'에서QueryDsl 메소드의 findBy[엔티티](엔티티 diaryUser) 부분에서 [엔티티]와 엔티티 명을 다르게 했기 때문 | 'EmailVerificationRepository.java'에서 QueryDsl 메소드의 findBy[엔티티](엔티티 diaryUser) 부분에서 [엔티티]와 엔티티 명을 같게 수정 | 2025-09-15  |



