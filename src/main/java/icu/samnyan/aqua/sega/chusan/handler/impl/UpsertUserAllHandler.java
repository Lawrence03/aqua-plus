package icu.samnyan.aqua.sega.chusan.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.chusan.handler.BaseHandler;
import icu.samnyan.aqua.sega.chusan.model.request.UpsertUserAll;
import icu.samnyan.aqua.sega.chusan.model.response.CodeResp;
import icu.samnyan.aqua.sega.chusan.model.userdata.*;
import icu.samnyan.aqua.sega.chusan.dao.userdata.*;
import icu.samnyan.aqua.sega.general.model.Card;
import icu.samnyan.aqua.sega.general.service.CardService;
import icu.samnyan.aqua.sega.util.jackson.StringMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * The handler for save user data. Only send in the end of the session.
 *
 * @author samnyan (privateamusement@protonmail.com)
 */
@Component("C3UpsertUserAllHandler")
public class UpsertUserAllHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(UpsertUserAllHandler.class);

    private final StringMapper mapper;

    private final CardService cardService;

    private final UserDataRepository userDataRepository;
    private final UserCharacterRepository userCharacterRepository;
    private final UserGameOptionRepository userGameOptionRepository;
    private final UserMapAreaRepository userMapAreaRepository;
    private final UserItemRepository userItemRepository;
    private final UserMusicRepository userMusicRepository;
    private final UserActivityRepository userActivityRepository;
    private final UserRecentRatingRepository userRecentRatingRepository;
    private final UserPlaylogRepository userPlaylogRepository;
    private final UserChargeRepository userChargeRepository;
    private final UserCourseRepository userCourseRepository;
    private final UserDuelRepository userDuelRepository;
    private final UserGeneralDataRepository userGeneralDataRepository;
    private final UserCMissionRepository userCMissionRepository;
    private final UserCMissionProgressRepository userCMissionProgressRepository;

    @Autowired
    public UpsertUserAllHandler(StringMapper mapper,
                                CardService cardService,
                                UserDataRepository userDataRepository,
                                UserCharacterRepository userCharacterRepository,
                                UserGameOptionRepository userGameOptionRepository,
                                UserMapAreaRepository userMapAreaRepository,
                                UserItemRepository userItemRepository,
                                UserMusicRepository userMusicRepository,
                                UserActivityRepository userActivityRepository,
                                UserRecentRatingRepository userRecentRatingRepository,
                                UserPlaylogRepository userPlaylogRepository,
                                UserChargeRepository userChargeRepository,
                                UserCourseRepository userCourseRepository,
                                UserDuelRepository userDuelRepository,
                                UserGeneralDataRepository userGeneralDataRepository,
                                UserCMissionRepository userCMissionRepository,
                                UserCMissionProgressRepository userCMissionProgressRepository) {
        this.mapper = mapper;
        this.cardService = cardService;
        this.userDataRepository = userDataRepository;
        this.userCharacterRepository = userCharacterRepository;
        this.userGameOptionRepository = userGameOptionRepository;
        this.userMapAreaRepository = userMapAreaRepository;
        this.userItemRepository = userItemRepository;
        this.userMusicRepository = userMusicRepository;
        this.userActivityRepository = userActivityRepository;
        this.userRecentRatingRepository = userRecentRatingRepository;
        this.userPlaylogRepository = userPlaylogRepository;
        this.userChargeRepository = userChargeRepository;
        this.userCourseRepository = userCourseRepository;
        this.userDuelRepository = userDuelRepository;
        this.userGeneralDataRepository = userGeneralDataRepository;
        this.userCMissionRepository = userCMissionRepository;
        this.userCMissionProgressRepository = userCMissionProgressRepository;
    }


    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {
        String userId = (String) request.get("userId");
        UpsertUserAll upsertUserAll = mapper.convert(request.get("upsertUserAll"), UpsertUserAll.class);

        // Not all field will be sent. Check if they are exist first.

        UserData userData;
        UserData newUserData;
        // UserData
        if (upsertUserAll.getUserData() == null) {
            return null;
        } else {
            newUserData = upsertUserAll.getUserData().get(0);

            Optional<UserData> userOptional = userDataRepository.findByCard_ExtId(Long.parseLong(userId));

            if (userOptional.isPresent()) {
                userData = userOptional.get();
            } else {
                userData = new UserData();
                Card card = cardService.getCardByExtId(userId).orElseThrow();
                userData.setCard(card);
            }

            newUserData.setId(userData.getId());
            newUserData.setCard(userData.getCard());
            newUserData.setAccessCode(userData.getCard().getLuid());

            // Decode Username
            String userName = new String(newUserData.getUserName()
                    .getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
            String userNameEx = new String(newUserData.getUserNameEx()
                    .getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);

            newUserData.setUserName(userName);
            newUserData.setUserNameEx(userNameEx);
            newUserData.setRankUpChallengeResults("[]");
            userDataRepository.saveAndFlush(newUserData);
        }

        // userGameOption
        if (upsertUserAll.getUserGameOption() != null) {
            UserGameOption newUserGameOption = upsertUserAll.getUserGameOption().get(0);

            Optional<UserGameOption> userGameOptionOptional = userGameOptionRepository.findByUser(newUserData);

            UserGameOption userGameOption = userGameOptionOptional.orElseGet(() -> new UserGameOption(newUserData));

            newUserGameOption.setId(userGameOption.getId());
            newUserGameOption.setUser(userGameOption.getUser());

            userGameOptionRepository.save(newUserGameOption);
        }

        // userMapAreaList
        if (upsertUserAll.getUserMapAreaList() != null) {
            List<UserMapArea> userMapList = upsertUserAll.getUserMapAreaList();
            Map<Integer, UserMapArea> newUserMapMap = new HashMap<>();

            userMapList.forEach(newUserMap -> {
                int mapId = newUserMap.getMapAreaId();
                UserMapArea userMap;
                Optional<UserMapArea> userMapOptional = userMapAreaRepository.findTopByUserAndMapAreaIdOrderByIdDesc(newUserData, mapId);
                userMap = userMapOptional.orElseGet(() -> new UserMapArea(newUserData));

                newUserMap.setId(userMap.getId());
                newUserMap.setUser(userMap.getUser());

                newUserMapMap.put(mapId, newUserMap);
            });
            userMapAreaRepository.saveAll(newUserMapMap.values());
        }

        // userCharacterList
        if (upsertUserAll.getUserCharacterList() != null) {
            List<UserCharacter> userCharacterList = upsertUserAll.getUserCharacterList();
            Map<Integer, UserCharacter> newCharacterMap = new HashMap<>();

            userCharacterList.forEach(newUserCharacter -> {
                int characterId = newUserCharacter.getCharacterId();

                Optional<UserCharacter> userCharacterOptional = userCharacterRepository
                        .findTopByUserAndCharacterIdOrderByIdDesc(newUserData, characterId);
                UserCharacter userCharacter = userCharacterOptional.orElseGet(() -> new UserCharacter(newUserData));

                newUserCharacter.setId(userCharacter.getId());
                newUserCharacter.setUser(userCharacter.getUser());

                newCharacterMap.put(characterId, newUserCharacter);
            });
            userCharacterRepository.saveAll(newCharacterMap.values());
        }

        // userItemList
        if (upsertUserAll.getUserItemList() != null) {
            List<UserItem> userItemList = upsertUserAll.getUserItemList();
            Map<String, UserItem> newUserItemMap = new HashMap<>();

            userItemList.forEach(newUserItem -> {
                int itemId = newUserItem.getItemId();
                int itemKind = newUserItem.getItemKind();


                Optional<UserItem> userItemOptional = userItemRepository
                        .findTopByUserAndItemIdAndItemKindOrderByIdDesc(newUserData, itemId, itemKind);
                UserItem userItem = userItemOptional.orElseGet(() -> new UserItem(newUserData));

                newUserItem.setId(userItem.getId());
                newUserItem.setUser(userItem.getUser());

                newUserItemMap.put(itemId + "-" + itemKind, newUserItem);
            });
            userItemRepository.saveAll(newUserItemMap.values());
        }

        // userMusicDetailList
        if (upsertUserAll.getUserMusicDetailList() != null) {

            List<UserMusic> userMusicDetailList = upsertUserAll.getUserMusicDetailList();
            Map<String, UserMusic> newUserMusicDetailMap = new HashMap<>();

            userMusicDetailList.forEach(newUserMusicDetail -> {
                int musicId = newUserMusicDetail.getMusicId();
                int level = newUserMusicDetail.getLevel();

                Optional<UserMusic> userMusicDetailOptional = userMusicRepository.findTopByUserAndMusicIdAndLevelOrderByIdDesc(newUserData, musicId, level);
                UserMusic userMusicDetail = userMusicDetailOptional.orElseGet(() -> new UserMusic(newUserData));

                newUserMusicDetail.setId(userMusicDetail.getId());
                newUserMusicDetail.setUser(userMusicDetail.getUser());

                newUserMusicDetailMap.put(musicId + "-" + level, newUserMusicDetail);
            });
            userMusicRepository.saveAll(newUserMusicDetailMap.values());
        }

        // userActivityList
        if (upsertUserAll.getUserActivityList() != null) {
            List<UserActivity> userActivityList = upsertUserAll.getUserActivityList();
            List<UserActivity> newUserActivityList = new LinkedList<>();

            userActivityList.forEach(newUserActivity -> {
                // No need to rename to activityId. jackson auto handle that
                int activityId = newUserActivity.getActivityId();
                int kind = newUserActivity.getKind();

                Optional<UserActivity> userActivityOptional = userActivityRepository
                        .findTopByUserAndActivityIdAndKindOrderByIdDesc(newUserData, activityId, kind);
                UserActivity userActivity = userActivityOptional.orElseGet(() -> new UserActivity(newUserData));

                newUserActivity.setId(userActivity.getId());
                newUserActivity.setUser(userActivity.getUser());

                newUserActivityList.add(newUserActivity);
            });
            userActivityRepository.saveAll(newUserActivityList);
        }

        // userRecentRatingList
        if (upsertUserAll.getUserRecentRatingList() != null) {
            List<UserRecentRating> userRecentRatingList = upsertUserAll.getUserRecentRatingList();
            List<UserRecentRating> newUserRecentRatingList = new LinkedList<>();

            for (int i = 0; i < userRecentRatingList.size(); i++) {
                UserRecentRating newUserRecentRating = userRecentRatingList.get(i);

                int sortOrder = i + 1;
                Optional<UserRecentRating> userRecentOptional = userRecentRatingRepository
                        .findTopByUserAndSortOrderOrderByIdAsc(newUserData, sortOrder);

                UserRecentRating userRecentRating = userRecentOptional.orElseGet(() -> new UserRecentRating(newUserData));

                newUserRecentRating.setId(userRecentRating.getId());
                newUserRecentRating.setUser(userRecentRating.getUser());
                newUserRecentRating.setSortOrder(sortOrder);

                newUserRecentRatingList.add(newUserRecentRating);
            }
            userRecentRatingRepository.saveAll(newUserRecentRatingList);
        }

        // userChargeList
        if (upsertUserAll.getUserChargeList() != null) {
            List<UserCharge> userChargeList = upsertUserAll.getUserChargeList();
            List<UserCharge> newUserChargeList = new ArrayList<>();

            userChargeList.forEach(newUserCharge -> {
                int chargeId = newUserCharge.getChargeId();

                Optional<UserCharge> userChargeOptional = userChargeRepository.findByUserAndChargeId(newUserData, chargeId);
                UserCharge userCharge = userChargeOptional.orElseGet(() -> new UserCharge(newUserData));

                newUserCharge.setId(userCharge.getId());
                newUserCharge.setUser(userCharge.getUser());

                newUserChargeList.add(newUserCharge);
            });
            userChargeRepository.saveAll(newUserChargeList);
        }

        // userPlaylogList
        if (upsertUserAll.getUserPlaylogList() != null) {
            List<UserPlaylog> userPlaylogList = upsertUserAll.getUserPlaylogList();
            List<UserPlaylog> newUserPlaylogList = new ArrayList<>();

            userPlaylogList.forEach(newUserPlaylog -> {
                newUserPlaylog.setUser(newUserData);

                newUserPlaylogList.add(newUserPlaylog);
            });
            if (newUserPlaylogList.size() > 0) {
                userPlaylogRepository.saveAll(newUserPlaylogList);
            }
        }

        // userCourseList
        if (upsertUserAll.getUserCourseList() != null) {
            List<UserCourse> userCourseList = upsertUserAll.getUserCourseList();

            userCourseList.forEach(newUserCourse -> {
                int courseId = newUserCourse.getCourseId();

                Optional<UserCourse> userCourseOptional = userCourseRepository
                        .findTopByUserAndCourseIdOrderByIdDesc(newUserData, courseId);
                UserCourse userCourse = userCourseOptional.orElseGet(() -> new UserCourse(newUserData));

                newUserCourse.setId(userCourse.getId());
                newUserCourse.setUser(userCourse.getUser());

                userCourseRepository.save(newUserCourse);
            });
        }

        // userDuelList
        if (upsertUserAll.getUserDuelList() != null) {
            List<UserDuel> userDuelList = upsertUserAll.getUserDuelList();
            Map<Integer, UserDuel> newUserDuelMap = new HashMap<>();

            userDuelList.forEach(newUserDuel -> {
                int duelId = newUserDuel.getDuelId();

                Optional<UserDuel> userDuelOptional = userDuelRepository.findTopByUserAndDuelIdOrderByIdDesc(newUserData, duelId);
                UserDuel userDuel = userDuelOptional.orElseGet(() -> new UserDuel(newUserData));

                newUserDuel.setId(userDuel.getId());
                newUserDuel.setUser(userDuel.getUser());

                newUserDuelMap.put(duelId, newUserDuel);
            });
            userDuelRepository.saveAll(newUserDuelMap.values());
        }

        // userCMission
        if (upsertUserAll.getUserCMissionList() != null) {
            List<UserCMission> userCMissionList = upsertUserAll.getUserCMissionList();
            List<UserCMission> newUserCMissionList = new ArrayList<>();

            userCMissionList.forEach(newUserCMission -> {
                int missionId = newUserCMission.getMissionId();

                Optional<UserCMission> userCMissionOptional = userCMissionRepository
                        .findByUserAndMissionId(newUserData, missionId);
                UserCMission userCMission = userCMissionOptional.orElseGet(() -> new UserCMission(newUserData));

                newUserCMission.setId(userCMission.getId());
                newUserCMission.setUser(userCMission.getUser());

                newUserCMissionList.add(newUserCMission);

                for (UserCMissionProgress userCMissionProgress : newUserCMission.getUserCMissionProgressList()) {
                    userCMissionProgress.setUserCMission(newUserCMission);
                }
            });
            userCMissionRepository.saveAll(newUserCMissionList);
        }

        String json = mapper.write(new CodeResp(1));
        logger.info("Response: " + json);
        return json;
    }
}
