package icu.samnyan.aqua.sega.mai2.handler.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.general.model.Card;
import icu.samnyan.aqua.sega.general.service.CardService;
import icu.samnyan.aqua.sega.mai2.dao.userdata.*;
import icu.samnyan.aqua.sega.mai2.model.request.UpsertUserAll;
import icu.samnyan.aqua.sega.mai2.model.request.data.UserAll;
import icu.samnyan.aqua.sega.mai2.model.request.data.UserRate;
import icu.samnyan.aqua.sega.mai2.model.userdata.*;
import icu.samnyan.aqua.sega.maimai.handler.BaseHandler;
import icu.samnyan.aqua.sega.util.jackson.BasicMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@Component("Mai2UpsertUserAllHandler")
public class UpsertUserAllHandler implements BaseHandler {

    private static final Logger logger = LoggerFactory.getLogger(UpsertUserAllHandler.class);

    private final BasicMapper mapper;

    private final CardService cardService;

    private final UserActivityRepository userActivityRepository;
    private final UserCharacterRepository userCharacterRepository;
    private final UserDataRepository userDataRepository;
    private final UserExtendRepository userExtendRepository;
    private final UserFavoriteRepository userFavoriteRepository;
    private final UserGeneralDataRepository userGeneralDataRepository;
    private final UserGhostRepository userGhostRepository;
    private final UserItemRepository userItemRepository;
    private final UserLoginBonusRepository userLoginBonusRepository;
    private final UserMapRepository userMapRepository;
    private final UserMusicDetailRepository userMusicDetailRepository;
    private final UserOptionRepository userOptionRepository;
    private final UserUdemaeRepository userUdemaeRepository;

    public UpsertUserAllHandler(BasicMapper mapper, CardService cardService, UserActivityRepository userActivityRepository, UserCharacterRepository userCharacterRepository, UserDataRepository userDataRepository, UserExtendRepository userExtendRepository, UserFavoriteRepository userFavoriteRepository, UserGeneralDataRepository userGeneralDataRepository, UserGhostRepository userGhostRepository, UserItemRepository userItemRepository, UserLoginBonusRepository userLoginBonusRepository, UserMapRepository userMapRepository, UserMusicDetailRepository userMusicDetailRepository, UserOptionRepository userOptionRepository, UserUdemaeRepository userUdemaeRepository) {
        this.mapper = mapper;
        this.cardService = cardService;
        this.userActivityRepository = userActivityRepository;
        this.userCharacterRepository = userCharacterRepository;
        this.userDataRepository = userDataRepository;
        this.userExtendRepository = userExtendRepository;
        this.userFavoriteRepository = userFavoriteRepository;
        this.userGeneralDataRepository = userGeneralDataRepository;
        this.userGhostRepository = userGhostRepository;
        this.userItemRepository = userItemRepository;
        this.userLoginBonusRepository = userLoginBonusRepository;
        this.userMapRepository = userMapRepository;
        this.userMusicDetailRepository = userMusicDetailRepository;
        this.userOptionRepository = userOptionRepository;
        this.userUdemaeRepository = userUdemaeRepository;
    }

    @Override
    public String handle(Map<String, Object> request) throws JsonProcessingException {

        UpsertUserAll upsertUserAll = mapper.convert(request, UpsertUserAll.class);
        long userId = upsertUserAll.getUserId();
        UserAll userAll = upsertUserAll.getUpsertUserAll();

        String json = "{\"returnCode\":\"1\",\"apiName\":\"UpsertUserAllApi\"}";
        logger.info("Response: " + json);

        // Skip guest request
        if ((userId & 281474976710657L) == 281474976710657L) {
            return json;
        }

        // UserData
        UserData userData;
        UserData newUserData = userAll.getUserData().get(0);
        Optional<UserData> userOptional = userDataRepository.findByCard_ExtId(userId);

        if(newUserData.getDateTime() == null) {
            newUserData.setDateTime(0L);
        }

        // Check if new user
        if (userOptional.isPresent()) {
            userData = userOptional.get();
        } else {
            userData = new UserData();
            Card card = cardService.getCardByExtId(userId).orElseThrow();
            userData.setCard(card);
        }

        newUserData.setId(userData.getId());
        newUserData.setCard(userData.getCard());

        userDataRepository.save(newUserData);

        // UserExtend
        UserExtend newUserExtend = userAll.getUserExtend().get(0);
        if(newUserExtend.getExtendContentBit() == null) {
            newUserExtend.setExtendContentBit(0L);
        }
        if(newUserExtend.getIsPhotoAgree() == null) {
            newUserExtend.setIsPhotoAgree(false);
        }
        if(newUserExtend.getIsGotoCodeRead() == null) {
            newUserExtend.setIsGotoCodeRead(false);
        }

        Optional<UserExtend> userExtendOptional = userExtendRepository.findByUser(newUserData);
        UserExtend userExtend = userExtendOptional.orElseGet(() -> new UserExtend(newUserData));

        newUserExtend.setId(userExtend.getId());
        newUserExtend.setUser(userExtend.getUser());
        userExtendRepository.save(newUserExtend);

        // UserOption
        UserOption newUserOption = userAll.getUserOption().get(0);

        Optional<UserOption> userOptionOptional = userOptionRepository.findByUser(newUserData);
        UserOption userOption = userOptionOptional.orElseGet(() -> new UserOption(newUserData));

        newUserOption.setId(userOption.getId());
        newUserOption.setUser(userOption.getUser());

        userOptionRepository.save(newUserOption);

        // UserCharacterList
        List<UserCharacter> userCharacterList = userAll.getUserCharacterList();
        List<UserCharacter> newUserCharacterList = new ArrayList<>();

        for(UserCharacter newUserCharacter: userCharacterList) {
            int characterId = newUserCharacter.getCharacterId();

            Optional<UserCharacter> characterOptional = userCharacterRepository.findByUserAndCharacterId(newUserData, characterId);
            UserCharacter userCharacter = characterOptional.orElseGet(() -> new UserCharacter(newUserData));

            newUserCharacter.setId(userCharacter.getId());
            newUserCharacter.setUser(newUserData);
            newUserCharacterList.add(newUserCharacter);
        }
        userCharacterRepository.saveAll(newUserCharacterList);

        // UserGhost
        List<UserGhost> userGhostList = userAll.getUserGhost();
        userGhostRepository.saveAll(userGhostList);

        // UserMapList
        List<UserMap> userMapList = userAll.getUserMapList();
        List<UserMap> newUserMapList = new ArrayList<>();

        for (UserMap newUserMap : userMapList) {
            int mapId = newUserMap.getMapId();

            Optional<UserMap> mapOptional = userMapRepository.findByUserAndMapId(newUserData, mapId);
            UserMap userMap = mapOptional.orElseGet(() -> new UserMap(newUserData));

            newUserMap.setId(userMap.getId());
            newUserMap.setUser(newUserData);
            newUserMapList.add(newUserMap);
        }
        userMapRepository.saveAll(newUserMapList);

        // UserLoginBonusList
        List<UserLoginBonus> userLoginBonusList = userAll.getUserLoginBonusList();
        if(userLoginBonusList != null) {
            List<UserLoginBonus> newUserLoginBonusList = new ArrayList<>();

            for (UserLoginBonus newUserLoginBonus : userLoginBonusList) {
                int mapId = newUserLoginBonus.getBonusId();

                Optional<UserLoginBonus> loginBonusOptional = userLoginBonusRepository.findByUserAndBonusId(newUserData, mapId);
                UserLoginBonus userMap = loginBonusOptional.orElseGet(() -> new UserLoginBonus(newUserData));

                newUserLoginBonus.setId(userMap.getId());
                newUserLoginBonus.setUser(newUserData);
                newUserLoginBonusList.add(newUserLoginBonus);
            }
            userLoginBonusRepository.saveAll(newUserLoginBonusList);
        }


        // UserRatingList
        this.saveGeneralData(userAll.getUserRatingList().get(0).getRatingList(), newUserData, "rating_list");
        this.saveGeneralData(userAll.getUserRatingList().get(0).getNewRatingList(), newUserData, "new_rating_list");
        this.saveGeneralData(userAll.getUserRatingList().get(0).getNextRatingList(), newUserData, "next_rating_list");
        this.saveGeneralData(userAll.getUserRatingList().get(0).getNextNewRatingList(), newUserData, "next_new_rating_list");

        // UserUdemae
        UserUdemae newUserUdemae = userAll.getUserRatingList().get(0).getUdemae();
        Optional<UserUdemae> optionalUserUdemae = userUdemaeRepository.findByUser(newUserData);
        UserUdemae userUdemae = optionalUserUdemae.orElseGet(() -> new UserUdemae(newUserData));

        newUserUdemae.setId(userUdemae.getId());
        newUserUdemae.setUser(userUdemae.getUser());

        userUdemaeRepository.save(newUserUdemae);

        // UserItemList
        List<UserItem> userItemList = userAll.getUserItemList();
        List<UserItem> newUserItemList = new ArrayList<>();

        for (UserItem newUserItem : userItemList) {
            int itemKind = newUserItem.getItemKind();
            int itemId = newUserItem.getItemId();

            Optional<UserItem> itemOptional = userItemRepository.findByUserAndItemKindAndItemId(newUserData, itemKind, itemId);
            UserItem userItem = itemOptional.orElseGet(() -> new UserItem(newUserData));

            newUserItem.setId(userItem.getId());
            newUserItem.setUser(newUserData);
            newUserItemList.add(newUserItem);
        }
        userItemRepository.saveAll(newUserItemList);

        // UserMusicDetailList
        List<UserMusicDetail> userMusicDetailList = userAll.getUserMusicDetailList();
        List<UserMusicDetail> newUserMusicDetailList = new ArrayList<>();

        for (UserMusicDetail newUserMusicDetail : userMusicDetailList) {
            int musicId = newUserMusicDetail.getMusicId();
            int level = newUserMusicDetail.getLevel();

            Optional<UserMusicDetail> musicDetailOptional = userMusicDetailRepository.findByUserAndMusicIdAndLevel(newUserData, musicId, level);
            UserMusicDetail userMusicDetail = musicDetailOptional.orElseGet(() -> new UserMusicDetail(newUserData));

            newUserMusicDetail.setId(userMusicDetail.getId());
            newUserMusicDetail.setUser(newUserData);
            newUserMusicDetailList.add(newUserMusicDetail);
        }
        userMusicDetailRepository.saveAll(newUserMusicDetailList);

        // UserFavoriteList
        List<UserFavorite> userFavoriteList = userAll.getUserFavoriteList();
        List<UserFavorite> newUserFavoriteList = new ArrayList<>();

        for (UserFavorite newUserFavorite : userFavoriteList) {
            int kind = newUserFavorite.getItemKind();

            Optional<UserFavorite> userFavoriteOptional = userFavoriteRepository.findByUserAndItemKind(newUserData, kind);
            UserFavorite userFavorite = userFavoriteOptional.orElseGet(() -> new UserFavorite(newUserData));

            newUserFavorite.setId(userFavorite.getId());
            newUserFavorite.setUser(newUserData);
            newUserFavoriteList.add(newUserFavorite);
        }
        userFavoriteRepository.saveAll(newUserFavoriteList);

        // UserActivityList
        List<UserActivity> userActivityList = userAll.getUserActivityList().get(0).getMusicList();
        userActivityList.addAll(userAll.getUserActivityList().get(0).getPlayList());
        List<UserActivity> newUserActivityList = new ArrayList<>();

        for (UserActivity newUserActivity : userActivityList) {
            int kind = newUserActivity.getKind();
            int id = newUserActivity.getActivityId();

            if (kind != 0 && id != 0) {
                Optional<UserActivity> activityOptional = userActivityRepository.findByUserAndKindAndActivityId(newUserData, kind, id);
                UserActivity userActivity = activityOptional.orElseGet(() -> new UserActivity(newUserData));

                newUserActivity.setId(userActivity.getId());
                newUserActivity.setUser(newUserData);
                newUserActivityList.add(newUserActivity);
            }
        }
        newUserActivityList.sort((a, b) -> Long.compare(b.getSortNumber(), a.getSortNumber()));
        userActivityRepository.saveAll(newUserActivityList);

        return json;
    }

    private void saveGeneralData(List<UserRate> itemList, UserData newUserData, String key) {
        StringBuilder sb = new StringBuilder();
        for(UserRate item: itemList) {
            sb.append(item.getMusicId()).append(":").append(item.getLevel()).append(":").append(item.getAchievement());
            sb.append(",");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        Optional<UserGeneralData> uOptional = userGeneralDataRepository.findByUserAndPropertyKey(newUserData, key);
        UserGeneralData userGeneralData = uOptional.orElseGet(() -> new UserGeneralData(newUserData, key));
        userGeneralData.setPropertyValue(sb.toString());
        userGeneralDataRepository.save(userGeneralData);
    }
}
