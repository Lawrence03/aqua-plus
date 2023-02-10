package icu.samnyan.aqua.sega.chusan.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.chusan.handler.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/ChusanServlet/ChuniServlet")
public class ChusanServletController {

    private final GameLoginHandler gameLoginHandler;
    private final GameLogoutHandler gameLogoutHandler;
    private final GetGameChargeHandler getGameChargeHandler;
    private final GetGameEventHandler getGameEventHandler;
    private final GetGameIdlistHandler getGameIdlistHandler;
    private final GetGameMessageHandler getGameMessageHandler;
    private final GetGameRankingHandler getGameRankingHandler;
    private final GetGameSaleHandler getGameSaleHandler;
    private final GetGameSettingHandler getGameSettingHandler;
    private final GetTeamCourseRuleHandler getTeamCourseRuleHandler;
    private final GetTeamCourseSettingHandler getTeamCourseSettingHandler;
    private final GetUserActivityHandler getUserActivityHandler;
    private final GetUserCharacterHandler getUserCharacterHandler;
    private final GetUserChargeHandler getUserChargeHandler;
    private final GetUserCourseHandler getUserCourseHandler;
    private final GetUserDataHandler getUserDataHandler;
    private final GetUserDuelHandler getUserDuelHandler;
    private final GetUserFavoriteItemHandler getUserFavoriteItemHandler;
    private final GetUserFavoriteMusicHandler getUserFavoriteMusicHandler;
    private final GetUserItemHandler getUserItemHandler;
    private final GetUserLoginBonusHandler getUserLoginBonusHandler;
    private final GetUserMapAreaHandler getUserMapAreaHandler;
    private final GetUserMusicHandler getUserMusicHandler;
    private final GetUserOptionHandler getUserOptionHandler;
    private final GetUserPreviewHandler getUserPreviewHandler;
    private final GetUserRecentRatingHandler getUserRecentRatingHandler;
    private final GetUserRegionHandler getUserRegionHandler;
    private final GetUserRivalDataHandler getUserRivalDataHandler;
    private final GetUserRivalMusicHandler getUserRivalMusicHandler;
    private final GetUserSymbolChatSettingHandler getUserSymbolChatSettingHandler;
    private final GetUserTeamHandler getUserTeamHandler;
    private final UpsertClientBookkeepingHandler upsertClientBookkeepingHandler;
    private final UpsertClientDevelopHandler upsertClientDevelopHandler;
    private final UpsertClientErrorHandler upsertClientErrorHandler;
    private final UpsertClientSettingHandler upsertClientSettingHandler;
    private final UpsertClientTestmodeHandler upsertClientTestmodeHandler;
    private final UpsertUserAllHandler upsertUserAllHandler;
    private final UpsertUserChargelogHandler upsertUserChargelogHandler;
    private final GetUserNetBattleDataHandler getUserNetBattleDataHandler;

    @Autowired
    public ChusanServletController(GameLoginHandler gameLoginHandler, GameLogoutHandler gameLogoutHandler,
                                   GetGameChargeHandler getGameChargeHandler, GetGameEventHandler getGameEventHandler,
                                   GetGameIdlistHandler getGameIdlistHandler, GetGameMessageHandler getGameMessageHandler,
                                   GetGameRankingHandler getGameRankingHandler, GetGameSaleHandler getGameSaleHandler,
                                   GetGameSettingHandler getGameSettingHandler, GetTeamCourseRuleHandler getTeamCourseRuleHandler,
                                   GetTeamCourseSettingHandler getTeamCourseSettingHandler, GetUserActivityHandler getUserActivityHandler,
                                   GetUserCharacterHandler getUserCharacterHandler, GetUserChargeHandler getUserChargeHandler,
                                   GetUserCourseHandler getUserCourseHandler,
                                   GetUserDataHandler getUserDataHandler, GetUserDuelHandler getUserDuelHandler,
                                   GetUserFavoriteItemHandler getUserFavoriteItemHandler,
                                   GetUserFavoriteMusicHandler getUserFavoriteMusicHandler, GetUserItemHandler getUserItemHandler, GetUserLoginBonusHandler getUserLoginBonusHandler,
                                   GetUserMapAreaHandler getUserMapAreaHandler, GetUserMusicHandler getUserMusicHandler,
                                   GetUserOptionHandler getUserOptionHandler,
                                   GetUserPreviewHandler getUserPreviewHandler, GetUserRecentRatingHandler getUserRecentRatingHandler,
                                   GetUserRegionHandler getUserRegionHandler,
                                   GetUserRivalDataHandler getUserRivalDataHandler,
                                   GetUserRivalMusicHandler getUserRivalMusicHandler,
                                   GetUserSymbolChatSettingHandler getUserSymbolChatSettingHandler,
                                   GetUserTeamHandler getUserTeamHandler,
                                   UpsertClientBookkeepingHandler upsertClientBookkeepingHandler,
                                   UpsertClientDevelopHandler upsertClientDevelopHandler, UpsertClientErrorHandler upsertClientErrorHandler,
                                   UpsertClientSettingHandler upsertClientSettingHandler,
                                   UpsertClientTestmodeHandler upsertClientTestmodeHandler, UpsertUserAllHandler upsertUserAllHandler,
                                   UpsertUserChargelogHandler upsertUserChargelogHandler,
                                   GetUserNetBattleDataHandler getUserNetBattleDataHandler) {
        this.gameLoginHandler = gameLoginHandler;
        this.gameLogoutHandler = gameLogoutHandler;
        this.getGameChargeHandler = getGameChargeHandler;
        this.getGameEventHandler = getGameEventHandler;
        this.getGameIdlistHandler = getGameIdlistHandler;
        this.getGameMessageHandler = getGameMessageHandler;
        this.getGameRankingHandler = getGameRankingHandler;
        this.getGameSaleHandler = getGameSaleHandler;
        this.getGameSettingHandler = getGameSettingHandler;
        this.getUserActivityHandler = getUserActivityHandler;
        this.getTeamCourseRuleHandler = getTeamCourseRuleHandler;
        this.getTeamCourseSettingHandler = getTeamCourseSettingHandler;
        this.getUserCharacterHandler = getUserCharacterHandler;
        this.getUserChargeHandler = getUserChargeHandler;
        this.getUserCourseHandler = getUserCourseHandler;
        this.getUserDataHandler = getUserDataHandler;
        this.getUserDuelHandler = getUserDuelHandler;
        this.getUserFavoriteItemHandler = getUserFavoriteItemHandler;
        this.getUserFavoriteMusicHandler = getUserFavoriteMusicHandler;
        this.getUserItemHandler = getUserItemHandler;
        this.getUserLoginBonusHandler = getUserLoginBonusHandler;
        this.getUserMapAreaHandler = getUserMapAreaHandler;
        this.getUserMusicHandler = getUserMusicHandler;
        this.getUserOptionHandler = getUserOptionHandler;
        this.getUserPreviewHandler = getUserPreviewHandler;
        this.getUserRecentRatingHandler = getUserRecentRatingHandler;
        this.getUserRegionHandler = getUserRegionHandler;
        this.getUserRivalDataHandler = getUserRivalDataHandler;
        this.getUserRivalMusicHandler = getUserRivalMusicHandler;
        this.getUserSymbolChatSettingHandler = getUserSymbolChatSettingHandler;
        this.getUserTeamHandler = getUserTeamHandler;
        this.upsertClientBookkeepingHandler = upsertClientBookkeepingHandler;
        this.upsertClientDevelopHandler = upsertClientDevelopHandler;
        this.upsertClientErrorHandler = upsertClientErrorHandler;
        this.upsertClientSettingHandler = upsertClientSettingHandler;
        this.upsertClientTestmodeHandler = upsertClientTestmodeHandler;
        this.upsertUserAllHandler = upsertUserAllHandler;
        this.upsertUserChargelogHandler = upsertUserChargelogHandler;
        this.getUserNetBattleDataHandler = getUserNetBattleDataHandler;
    }

    @PostMapping(value = "GameLoginApi")
    String gameLogin(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return gameLoginHandler.handle(request);
    }

    @PostMapping(value = {"GameLogoutApi", "CreateTokenApi", "RemoveTokenApi"})
    String gameLogout(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return gameLogoutHandler.handle(request);
    }

    @PostMapping(value = "GetGameChargeApi")
    String getGameCharge(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getGameChargeHandler.handle(request);
    }

    @PostMapping(value = "GetGameEventApi")
    String getGameEvent(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getGameEventHandler.handle(request);
    }

    @PostMapping(value = "GetGameIdlistApi")
    String getGameIdList(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getGameIdlistHandler.handle(request);
    }

    @PostMapping(value = "GetGameMessageApi")
    String getGameMessage(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getGameMessageHandler.handle(request);
    }

    @PostMapping(value = "GetGameRankingApi")
    String getGameRanking(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getGameRankingHandler.handle(request);
    }

    @PostMapping(value = "GetGameSaleApi")
    String getGameSale(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getGameSaleHandler.handle(request);
    }

    /**
     * The game start up request
     *
     * @return json of GameSetting object
     */
    @PostMapping(value = "GetGameSettingApi")
    String getGameSetting(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getGameSettingHandler.handle(request);
    }

    @PostMapping(value = "GetTeamCourseRuleApi")
    String getTeamCourseRule(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getTeamCourseRuleHandler.handle(request);
    }

    @PostMapping(value = "GetTeamCourseSettingApi")
    String getTeamCourseSetting(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getTeamCourseSettingHandler.handle(request);
    }

    @PostMapping(value = "GetUserActivityApi")
    String getUserActivity(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserActivityHandler.handle(request);
    }

    @PostMapping(value = "GetUserCharacterApi")
    String getUserCharacter(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserCharacterHandler.handle(request);
    }

    @PostMapping(value = "GetUserChargeApi")
    String getUserCharge(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserChargeHandler.handle(request);
    }

    @PostMapping(value = "GetUserCourseApi")
    String getUserCourse(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserCourseHandler.handle(request);
    }

    @PostMapping(value = "GetUserDataApi")
    String getUserData(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserDataHandler.handle(request);
    }

    @PostMapping(value = "GetUserDuelApi")
    String getUserDuel(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserDuelHandler.handle(request);
    }

    @PostMapping(value = "GetUserFavoriteItemApi")
    public String getUserFavoriteItem(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserFavoriteItemHandler.handle(request);
    }

    @PostMapping(value = "GetUserFavoriteMusicApi")
    public String getUserFavoriteMusic(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserFavoriteMusicHandler.handle(request);
    }

    @PostMapping(value = "GetUserItemApi")
    String getUserItem(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserItemHandler.handle(request);
    }

    @PostMapping(value = "GetUserLoginBonusApi")
    String getUserLoginBonus(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserLoginBonusHandler.handle(request);
    }

    @PostMapping(value = "GetUserMapAreaApi")
    String getUserMap(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserMapAreaHandler.handle(request);
    }

    @PostMapping(value = "GetUserMusicApi")
    String getUserMusic(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserMusicHandler.handle(request);
    }

    @PostMapping(value = "GetUserOptionApi")
    String getUserOption(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserOptionHandler.handle(request);
    }

    // Call when login. Return null if no profile exist
    @PostMapping(value = "GetUserPreviewApi")
    String getUserPreview(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserPreviewHandler.handle(request);
    }

    @PostMapping(value = "GetUserRecentRatingApi")
    String getUserRecentRating(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserRecentRatingHandler.handle(request);
    }

    @PostMapping(value = "GetUserRegionApi")
    String getUserRegion(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserRegionHandler.handle(request);
    }

    @PostMapping(value = "GetUserRivalDataApi")
    public String getUserRivalData(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserRivalDataHandler.handle(request);
    }

    @PostMapping(value = "GetUserRivalMusicApi")
    public String getUserRivalMusic(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserRivalMusicHandler.handle(request);
    }

    @PostMapping(value = "GetUserSymbolChatSettingApi")
    public String getUserSymbolChatSetting(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserSymbolChatSettingHandler.handle(request);
    }

    @PostMapping(value = "GetUserTeamApi")
    public String getUserTeam(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserTeamHandler.handle(request);
    }

    @PostMapping(value = "UpsertClientBookkeepingApi")
    String upsertClientBookkeeping(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return upsertClientBookkeepingHandler.handle(request);
    }

    @PostMapping(value = "UpsertClientDevelopApi")
    String upsertClientDevelop(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return upsertClientDevelopHandler.handle(request);
    }

    @PostMapping(value = "UpsertClientErrorApi")
    String upsertClientError(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return upsertClientErrorHandler.handle(request);
    }

    @PostMapping(value = "UpsertClientSettingApi")
    String upsertClientSetting(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return upsertClientSettingHandler.handle(request);
    }

    @PostMapping(value = "UpsertClientTestmodeApi")
    String upsertClientTestmode(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return upsertClientTestmodeHandler.handle(request);
    }

    @PostMapping(value = "UpsertUserAllApi")
    String upsertUserAll(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return upsertUserAllHandler.handle(request);
    }

    @PostMapping(value = "UpsertUserChargelogApi")
    String upsertUserChargelog(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return upsertUserChargelogHandler.handle(request);
    }

    @PostMapping(value = "GetUserNetBattleDataApi")
    String getUserNetBattleData(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserNetBattleDataHandler.handle(request);
    }
}
