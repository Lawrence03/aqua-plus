package icu.samnyan.aqua.sega.chunithm.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.chunithm.handler.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@RestController
@RequestMapping({ "/ChuniServlet/{ROM_VERSION}/{CLIENT_ID}/ChuniServlet", "/ChuniServlet" })
public class ChuniServletController {

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
    private final GetUserDataExHandler getUserDataExHandler;
    private final GetUserDataHandler getUserDataHandler;
    private final GetUserDuelHandler getUserDuelHandler;
    private final GetUserFavoriteItemHandler getUserFavoriteItemHandler;
    private final GetUserFavoriteMusicHandler getUserFavoriteMusicHandler;
    private final GetUserItemHandler getUserItemHandler;
    private final GetUserLoginBonusHandler getUserLoginBonusHandler;
    private final GetUserMapHandler getUserMapHandler;
    private final GetUserMusicHandler getUserMusicHandler;
    private final GetUserOptionExHandler getUserOptionExHandler;
    private final GetUserOptionHandler getUserOptionHandler;
    private final GetUserPreviewHandler getUserPreviewHandler;
    private final GetUserRecentRatingHandler getUserRecentRatingHandler;
    private final GetUserRegionHandler getUserRegionHandler;
    private final GetUserTeamHandler getUserTeamHandler;
    private final UpsertClientBookkeepingHandler upsertClientBookkeepingHandler;
    private final UpsertClientDevelopHandler upsertClientDevelopHandler;
    private final UpsertClientErrorHandler upsertClientErrorHandler;
    private final UpsertClientSettingHandler upsertClientSettingHandler;
    private final UpsertClientTestmodeHandler upsertClientTestmodeHandler;
    private final UpsertUserAllHandler upsertUserAllHandler;
    private final UpsertUserChargelogHandler upsertUserChargelogHandler;

    @Autowired
    public ChuniServletController(GameLoginHandler gameLoginHandler, GameLogoutHandler gameLogoutHandler,
            GetGameChargeHandler getGameChargeHandler, GetGameEventHandler getGameEventHandler,
            GetGameIdlistHandler getGameIdlistHandler, GetGameMessageHandler getGameMessageHandler,
            GetGameRankingHandler getGameRankingHandler, GetGameSaleHandler getGameSaleHandler,
            GetGameSettingHandler getGameSettingHandler, GetTeamCourseRuleHandler getTeamCourseRuleHandler,
            GetTeamCourseSettingHandler getTeamCourseSettingHandler, GetUserActivityHandler getUserActivityHandler,
            GetUserCharacterHandler getUserCharacterHandler, GetUserChargeHandler getUserChargeHandler,
            GetUserCourseHandler getUserCourseHandler, GetUserDataExHandler getUserDataExHandler,
            GetUserDataHandler getUserDataHandler, GetUserDuelHandler getUserDuelHandler,
            GetUserFavoriteItemHandler getUserFavoriteItemHandler,
            GetUserFavoriteMusicHandler getUserFavoriteMusicHandler, GetUserItemHandler getUserItemHandler, GetUserLoginBonusHandler getUserLoginBonusHandler,
            GetUserMapHandler getUserMapHandler, GetUserMusicHandler getUserMusicHandler,
            GetUserOptionExHandler getUserOptionExHandler, GetUserOptionHandler getUserOptionHandler,
            GetUserPreviewHandler getUserPreviewHandler, GetUserRecentRatingHandler getUserRecentRatingHandler,
            GetUserRegionHandler getUserRegionHandler, GetUserTeamHandler getUserTeamHandler,
            UpsertClientBookkeepingHandler upsertClientBookkeepingHandler,
            UpsertClientDevelopHandler upsertClientDevelopHandler, UpsertClientErrorHandler upsertClientErrorHandler,
            UpsertClientSettingHandler upsertClientSettingHandler,
            UpsertClientTestmodeHandler upsertClientTestmodeHandler, UpsertUserAllHandler upsertUserAllHandler,
            UpsertUserChargelogHandler upsertUserChargelogHandler) {
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
        this.getUserDataExHandler = getUserDataExHandler;
        this.getUserDataHandler = getUserDataHandler;
        this.getUserDuelHandler = getUserDuelHandler;
        this.getUserFavoriteItemHandler = getUserFavoriteItemHandler;
        this.getUserFavoriteMusicHandler = getUserFavoriteMusicHandler;
        this.getUserItemHandler = getUserItemHandler;
        this.getUserLoginBonusHandler = getUserLoginBonusHandler;
        this.getUserMapHandler = getUserMapHandler;
        this.getUserMusicHandler = getUserMusicHandler;
        this.getUserOptionExHandler = getUserOptionExHandler;
        this.getUserOptionHandler = getUserOptionHandler;
        this.getUserPreviewHandler = getUserPreviewHandler;
        this.getUserRecentRatingHandler = getUserRecentRatingHandler;
        this.getUserRegionHandler = getUserRegionHandler;
        this.getUserTeamHandler = getUserTeamHandler;
        this.upsertClientBookkeepingHandler = upsertClientBookkeepingHandler;
        this.upsertClientDevelopHandler = upsertClientDevelopHandler;
        this.upsertClientErrorHandler = upsertClientErrorHandler;
        this.upsertClientSettingHandler = upsertClientSettingHandler;
        this.upsertClientTestmodeHandler = upsertClientTestmodeHandler;
        this.upsertUserAllHandler = upsertUserAllHandler;
        this.upsertUserChargelogHandler = upsertUserChargelogHandler;
    }

    @PostMapping(value = { "GameLoginApi", "70231703c63ec5382a33f1670cb33dfc", "145234ed22eaedeed072fc37288d00d3" })
    String gameLogin(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return gameLoginHandler.handle(request);
    }

    @PostMapping(value = { "GameLogoutApi", "785d40b5a2f9bd2b20475a632c8b8754", "e5df523c41cd871bfa33fecfb1fa80cb" })
    String gameLogout(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return gameLogoutHandler.handle(request);
    }

    @PostMapping(value = { "GetGameChargeApi", "8bf6c8122434b0ce1ec9cc3fdc8522ef", "a576344319b7606f2fc8b0e50bd31615" })
    String getGameCharge(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getGameChargeHandler.handle(request);
    }

    @PostMapping(value = { "GetGameEventApi", "7a147e7263ac69f7c8ce6ae60a975235", "996595133ade40f94f7d15cbd9e0c525" })
    String getGameEvent(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getGameEventHandler.handle(request);
    }

    @PostMapping(value = { "GetGameIdlistApi", "dc1ca7a217ecf9043fcbcedae36f1009", "f7d56345a8061cc5aa0324ac8813672a" })
    String getGameIdList(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getGameIdlistHandler.handle(request);
    }

    @PostMapping(value = { "GetGameMessageApi", "ff780e0ffdba20a669f9d7e8510f617e",
            "7a490f9c94d60e484637ca7fc53009ac" })
    String getGameMessage(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getGameMessageHandler.handle(request);
    }

    @PostMapping(value = { "GetGameRankingApi", "23e0c6ee77635ace42c1d420d6ce9f84",
            "1fd26acfc5b268b15103d9e630439ac6" })
    String getGameRanking(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getGameRankingHandler.handle(request);
    }

    @PostMapping(value = { "GetGameSaleApi", "b7483df5d2ffaa9214092d63563720f4", "f3f40dbb2e3fb78d6da48099e7d21a39" })
    String getGameSale(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getGameSaleHandler.handle(request);
    }

    /**
     * The game start up request
     *
     * @return json of GameSetting object
     */
    @PostMapping(value = { "GetGameSettingApi", "34d76f06fc5de980485e539e9125f221",
            "a385e7b2ce6f36fa3b420ac003477134" })
    String getGameSetting(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getGameSettingHandler.handle(request);
    }

    @PostMapping(value = { "GetTeamCourseRuleApi", "f840ddb2b7366c6a4699cd7ee815c4d4",
            "73b2d5b98a994ab66b6856d3f7e2e7ab" })
    String getTeamCourseRule(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getTeamCourseRuleHandler.handle(request);
    }

    @PostMapping(value = { "GetTeamCourseSettingApi", "5accd969e4cf64244c03f6faba0d3591",
            "2274a09fceb1ba98bab47ffbfadba813" })
    String getTeamCourseSetting(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getTeamCourseSettingHandler.handle(request);
    }

    @PostMapping(value = { "GetUserActivityApi", "fd522f3a036bd568799ad4b74e56a907",
            "42cd1d311e2ac1a834dd194276a74329" })
    String getUserActivity(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserActivityHandler.handle(request);
    }

    @PostMapping(value = { "GetUserCharacterApi", "84c2345e2a43d925b216e780244d4e6e",
            "69f2b1e4ad8ff70e67dfbbce696eeebe" })
    String getUserCharacter(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserCharacterHandler.handle(request);
    }

    @PostMapping(value = { "GetUserChargeApi", "dbd65d37310efe48b6dcffd2e08fb5b7", "8c7042591ee76ace6edec12ec573f3bb" })
    String getUserCharge(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserChargeHandler.handle(request);
    }

    @PostMapping(value = { "GetUserCourseApi", "ec75ca2cbf9a59a1884a1e0039df5353", "5e4fa9526644a29cea092ccfafb73441" })
    String getUserCourse(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserCourseHandler.handle(request);
    }

    @PostMapping(value = { "GetUserDataApi", "7f3bcd3f1f85f31a90c30e935edc85e4", "8fdbce3d4cbd8f31792d65cff3792402" })
    String getUserData(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserDataHandler.handle(request);
    }

    @PostMapping(value = { "GetUserDataExApi", "00eec3afed5b29bbfa2dfacaff7d2301", "61aaedec4e7d0c4d8d5d8ada2ac9e2d1" })
    String getUserDataEx(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserDataExHandler.handle(request);
    }

    @PostMapping(value = { "GetUserDuelApi", "44b00c4daa406ce00deb38ddbb8dca4f", "fc4b62a1fd0ef493bacc6b5912214dfb" })
    String getUserDuel(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserDuelHandler.handle(request);
    }

    @PostMapping(value = { "GetUserFavoriteItemApi", "2c14d63bf5fd2f0dd78b073aef4db928",
            "3f223e1074c5044e2a27d646d59bb4cb" })
    public String getUserFavoriteItem(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserFavoriteItemHandler.handle(request);
    }

    @PostMapping(value = { "GetUserFavoriteMusicApi", "b48eb24b138ec95e2e98af8a330e1b03",
            "b1923a91216fc5c147d56b06e73c8b0c" })
    public String getUserFavoriteMusic(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserFavoriteMusicHandler.handle(request);
    }

    @PostMapping(value = { "GetUserItemApi", "3599c3cc56e55bdafd73908a470c0816", "e6d2162d585d96e27dfd1c6d4ad918d4" })
    String getUserItem(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserItemHandler.handle(request);
    }

    @PostMapping(value = { "GetUserLoginBonusApi", "bc92780685eebd1db77cd06f7aa2c387" })
    String getUserLoginBonus(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserLoginBonusHandler.handle(request);
    }

    @PostMapping(value = { "GetUserMapApi", "c5e6ebf444548f127a37c711c4b2c56b", "08050add39a5f23a1b04e7be98b2bf13" })
    String getUserMap(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserMapHandler.handle(request);
    }

    @PostMapping(value = { "GetUserMusicApi", "c3d174bbf4028bfe649d7eaaf6a23fe9", "65fd9eb5f49ce429b9dfac1ead394ee5" })
    String getUserMusic(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserMusicHandler.handle(request);
    }

    @PostMapping(value = { "GetUserOptionApi", "7f08902d48b111e91f1a4a3c0bdc8dd3", "a967010460be652c25fbfbe9e08d4da8" })
    String getUserOption(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserOptionHandler.handle(request);
    }

    @PostMapping(value = { "GetUserOptionExApi", "991419d6fef4e3fb495bc85a15c7b90a",
            "fc7736c639ff860a0900533a6ee38338" })
    String getUserOptionEx(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserOptionExHandler.handle(request);
    }

    // Call when login. Return null if no profile exist
    @PostMapping(value = { "GetUserPreviewApi", "ca5035d06c8374517b2370ad6ec1eb41",
            "4d0853cba2d7f0de85b0588e472e9b74" })
    String getUserPreview(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserPreviewHandler.handle(request);
    }

    @PostMapping(value = { "GetUserRecentRatingApi", "203398f53b6db9c50cb7c30fe4667ea8",
            "6c45721ed1e25f7bea3b7de94deb23a3" })
    String getUserRecentRating(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserRecentRatingHandler.handle(request);
    }

    /**
     * For older version chunithm
     */
    @PostMapping(value = { "GetUserRecentPlayerApi", "33bbe180e025693d1ac80da869fed1d8",
            "a5e8f2667840d9ed538091cbc73ffffa" })
    String getUserRecentPlayerApi(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserRecentRatingHandler.handle(request);
    }

    @PostMapping(value = { "GetUserRegionApi", "fd06978c80a889cff3ab717a34875489", "481728ac18c832afd54d93d2a19cfe54" })
    String getUserRegion(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserRegionHandler.handle(request);
    }

    @PostMapping(value = { "GetUserTeamApi", "d1356fffc0213047cf57173310372a7a", "70bf6b27762665f7ec017c393b434009" })
    public String getUserTeam(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserTeamHandler.handle(request);
    }

    @PostMapping(value = { "UpsertClientBookkeepingApi", "afad1379d9324f2d834df61255c7a95f",
            "00c623987659c9129a78575a014a62bc" })
    String upsertClientBookkeeping(@ModelAttribute Map<String, Object> request) {
        return "{\"returnCode\":\"1\"}";
    }

    @PostMapping(value = { "UpsertClientDevelopApi", "692cbc553ed09bcde72fec0abec99b4a",
            "5db1ab2a6385e7f95e2d81e65a27cd6e" })
    String upsertClientDevelop(@ModelAttribute Map<String, Object> request) {
        return "{\"returnCode\":\"1\"}";
    }

    @PostMapping(value = { "UpsertClientErrorApi", "4cb82a86f8fb168b3179fed4625a5d64",
            "3d63e4c51521fb73663f3357970b1807" })
    String upsertClientError(@ModelAttribute Map<String, Object> request) {
        return "{\"returnCode\":\"1\"}";
    }

    @PostMapping(value = { "UpsertClientSettingApi", "6baab69d708df880f240412b2c7a8094",
            "c4298ab12d287fdf40b30acd6dba3864" })
    String upsertClientSetting(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return upsertClientSettingHandler.handle(request);
    }

    @PostMapping(value = { "UpsertClientTestmodeApi", "e5b312cbb7ce0e0d662d458e47a74d1f",
            "0cc3c9c4dfadd70ea3426c0991835321" })
    String upsertClientTestmode(@ModelAttribute Map<String, Object> request) {
        return "{\"returnCode\":\"1\"}";
    }

    @PostMapping(value = { "UpsertUserAllApi", "65ef911a7525e2073dc3d2c9233c8b3e", "31a859bf2c3b5ad5cf1702252ee4cf35" })
    String upsertUserAll(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return upsertUserAllHandler.handle(request);
    }

    @PostMapping(value = { "UpsertUserChargelogApi", "0f250fba550ce3876068b2d9bc12e381",
            "d2d01b3ed6a2929c7c0a22f3a6969e32" })
    String upsertUserChargelog(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return upsertUserChargelogHandler.handle(request);
    }

}
