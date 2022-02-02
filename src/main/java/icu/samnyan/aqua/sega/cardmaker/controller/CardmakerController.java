package icu.samnyan.aqua.sega.cardmaker.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.cardmaker.handler.impl.*;
import icu.samnyan.aqua.sega.chunithm.handler.impl.GetUserItemHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("CardmakerServlet")
public class CardmakerController {

    private final GetGameSettingHandler getGameSettingHandler;
    private final GetGameConnectHandler getGameConnectHandler;
    private final OngekiCMGetUserDataHandler ongekiCMGetUserDataHandler;
    private final OngekiCMGetUserCardHandler ongekiCMGetUserCardHandler;
    private final OngekiCMGetUserCharacterHandler ongekiCMGetUserCharacterHandler;
    private final OngekiGetUserGachaHandler ongekiGetUserGachaHandler;
    private final OngekiCMGetUserItemHandler ongekiCMGetUserItemHandler;
    private final OngekiGetUserGachaSupplyHandler ongekiGetUserGachaSupplyHandler;
    private final MaiCMGetUserPreviewHandler maiCMGetUserPreviewHandler;
    private final MaiCMGetSellingCardHandler maiCMGetSellingCardHandler;
    private final MaiCMGetUserDataHandler maiCMGetUserDataHandler;
    private final MaiCMGetUserCardHandler maiCMGetUserCardHandler;
    private final MaiCMGetUserCharacterHandler maiCMGetUserCharacterHandler;
    private final MaiCMGetUserItemHandler maiCMGetUserItemHandler;

    @Autowired
    public CardmakerController(GetGameSettingHandler getGameSettingHandler,
                               GetGameConnectHandler getGameConnectHandler,
                               OngekiCMGetUserDataHandler ongekiCMGetUserDataHandler,
                               OngekiCMGetUserCardHandler ongekiCMGetUserCardHandler,
                               OngekiCMGetUserCharacterHandler ongekiCMGetUserCharacterHandler,
                               OngekiGetUserGachaHandler ongekiGetUserGachaHandler,
                               OngekiCMGetUserItemHandler ongekiCMGetUserItemHandler,
                               OngekiGetUserGachaSupplyHandler ongekiGetUserGachaSupplyHandler,
                               MaiCMGetUserPreviewHandler maiCMGetUserPreviewHandler,
                               MaiCMGetSellingCardHandler maiCMGetSellingCardHandler,
                               MaiCMGetUserDataHandler maiCMGetUserDataHandler,
                               MaiCMGetUserCardHandler maiCMGetUserCardHandler,
                               MaiCMGetUserCharacterHandler maiCMGetUserCharacterHandler,
                               MaiCMGetUserItemHandler maiCMGetUserItemHandler){
        this.getGameSettingHandler = getGameSettingHandler;
        this.getGameConnectHandler = getGameConnectHandler;
        this.ongekiCMGetUserDataHandler = ongekiCMGetUserDataHandler;
        this.ongekiCMGetUserCardHandler = ongekiCMGetUserCardHandler;
        this.ongekiCMGetUserCharacterHandler = ongekiCMGetUserCharacterHandler;
        this.ongekiGetUserGachaHandler = ongekiGetUserGachaHandler;
        this.ongekiCMGetUserItemHandler = ongekiCMGetUserItemHandler;
        this.ongekiGetUserGachaSupplyHandler = ongekiGetUserGachaSupplyHandler;
        this.maiCMGetUserPreviewHandler = maiCMGetUserPreviewHandler;
        this.maiCMGetSellingCardHandler = maiCMGetSellingCardHandler;
        this.maiCMGetUserDataHandler = maiCMGetUserDataHandler;
        this.maiCMGetUserCardHandler = maiCMGetUserCardHandler;
        this.maiCMGetUserItemHandler = maiCMGetUserItemHandler;
        this.maiCMGetUserCharacterHandler = maiCMGetUserCharacterHandler;
    }

    @PostMapping(value = {"GetGameConnectApi"})
    public String getGameConnect(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getGameConnectHandler.handle(request);
    }

    @PostMapping(value = {"GetGameSettingApi"})
    public String getGameSetting(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getGameSettingHandler.handle(request);
    }

    @PostMapping(value = {"UpsertClientBookkeepingApi"})
    public String upsertClientBookkeeping(@ModelAttribute Map<String, Object> request) throws JsonParseException {
        return "{\"returnCode\":1,\"apiName\": \"upsertClientBookkeeping\"}";
    }

    @PostMapping(value = {"UpsertClientSettingApi"})
    public String upsertClientSetting(@ModelAttribute Map<String, Object> request) throws JsonParseException{
        return "{\"returnCode\":1,\"apiName\": \"upsertClientSetting\"}";
    }

    @PostMapping(value = {"GetClientBookkeepingApi"})
    public String getClientBookkeeping(@ModelAttribute Map<String, Object> request){
        return "";
    }

    // For Ongeki

    @PostMapping(value = {"Ongeki/GetGameGachaApi"})
    public String ongekiGetGameGacha(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return "{\"length\":0,\"gameGachaList\":[],\"registIdList\":[]}";
    }

    @PostMapping(value = {"Ongeki/GetGameGachaCardByIdApi"})
    public String ongekiGetGameGachaCardById(@ModelAttribute Map<String, Object> request){
        return "";
    }

    @PostMapping(value = {"Ongeki/GetGameTheaterApi"})
    public String ongekiGetGameTheater(@ModelAttribute Map<String, Object> request){
        return "{\"length\":0,\"gameTheaterList\":[],\"registIdList\":[]}";
    }

    @PostMapping(value = {"Ongeki/CMGetUserCardApi"})
    public String ongekiCMGetUserCard(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return ongekiCMGetUserCardHandler.handle(request);
    }

    @PostMapping(value = {"Ongeki/CMGetUserCharacterApi"})
    public String ongekiCMGetUserCharacter(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return ongekiCMGetUserCharacterHandler.handle(request);
    }

    @PostMapping(value = {"Ongeki/CMGetUserDataApi"})
    public String ongekiCMGetUserData(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return ongekiCMGetUserDataHandler.handle(request);
    }

    @PostMapping(value = {"Ongeki/GetUserGachaApi"})
    public String ongekiGetUserGacha(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return ongekiGetUserGachaHandler.handle(request);
    }

    @PostMapping(value = {"Ongeki/CMGetUserGachaSupplyApi"})
    public String ongekiCMGetUserGachaSupply(@ModelAttribute Map<String, Object> request)throws JsonProcessingException {
        return ongekiGetUserGachaSupplyHandler.handle(request);
    }

    @PostMapping(value = {"Ongeki/CMGetUserItemApi"})
    public String ongekiCMGetUserItem(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return ongekiCMGetUserItemHandler.handle(request);
    }

    @PostMapping(value = {"Ongeki/Ping"})
    public String ongekiPing(@ModelAttribute Map<String, Object> request){
        return "{\"result\":1}";
    }

    @PostMapping(value = {"Ongeki/PrinterLoginApi"})
    public String ongekiPrinterLogin(@ModelAttribute Map<String, Object> request){
        return "{\"returnCode\":1}";
    }

    @PostMapping(value = {"Ongeki/PrinterLogoutApi"})
    public String ongekiPrinterLogout(@ModelAttribute Map<String, Object> request){
        return "{\"returnCode\":1}";
    }

    @PostMapping(value = {"Ongeki/RollGachaApi"})
    public String ongekiRollGacha(@ModelAttribute Map<String, Object> request){
        return "";
    }

    @PostMapping(value = {"Ongeki/CMUpsertUserAllApi"})
    public String ongekiCMUpsertUserAll(@ModelAttribute Map<String, Object> request){
        return "{\"returnCode\":1,\"apiName\":\"CMUpsertUserAll\"}";
    }

    @PostMapping(value = {"Ongeki/CMUpsertUserGachaApi"})
    public String ongekiCMUpsertUserGacha(@ModelAttribute Map<String, Object> request){
        return "{\"returnCode\":1,\"apiName\":\"CMUpsertUserGacha\"}";
    }

    @PostMapping(value = {"Ongeki/CMUpsertUserPrintApi"})
    public String ongekiCMUpsertUserPrint(@ModelAttribute Map<String, Object> request){
        return "{\"returnCode\":1,\"orderId\":0,\"serialId\": \"\",\"apiName\":\"CMUpsertUserPrint\"}";
    }

    @PostMapping(value = {"Ongeki/CMUpsertUserPrintlogApi"})
    public String ongekiCMUpsertUserPrintlog(@ModelAttribute Map<String, Object> request) {
        return "{\"returnCode\":1,\"orderId\":0,\"serialId\": \"\",\"apiName\":\"CMUpsertUserPrintlog\"}";
    }

    @PostMapping(value = {"Ongeki/CMUpsertUserPrintPlaylogApi"})
    public String ongekiCMUpsertUserPrintPlaylog(@ModelAttribute Map<String, Object> request) {
        return "{\"returnCode\":1,\"orderId\":0,\"serialId\": \"\",\"apiName\":\"CMUpsertUserPrintPlaylog\"}";
    }

    @PostMapping(value = {"Ongeki/CMUpsertUserSelectGachaApi"})
    public String ongekiCMUpsertUserSelectGacha(@ModelAttribute Map<String, Object> request){
        return "{\"returnCode\":1,\"apiName\":\"CMUpsertUserSelectGacha\"}";
    }

    // For Maimai DX

    @PostMapping(value = {"Mai/CMGetSellingCardApi"})
    public String maiCMGetSellingCard(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return maiCMGetSellingCardHandler.handle(request);
    }

    @PostMapping(value = {"Mai/CMGetUserCardApi"})
    public String maiCMGetUserCard(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return maiCMGetUserCardHandler.handle(request);
    }

    @PostMapping(value = {"Mai/CMGetUserCardPrintErrorApi"})
    public String maiCMGetUserCardPrintError(@ModelAttribute Map<String, Object> request){
        return "{\"length\":0,\"userPrintDetailList\":[]}";
    }

    @PostMapping(value = {"Mai/CMGetUserCharacterApi"})
    public String maiCMGetUserCharacter(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return maiCMGetUserCharacterHandler.handle(request);
    }

    @PostMapping(value = {"Mai/CMGetUserDataApi"})
    public String maiCMGetUserData(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {

        return maiCMGetUserDataHandler.handle(request);
    }

    @PostMapping(value = {"Mai/CMGetUserItemApi"})
    public String maiCMGetUserItem(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return maiCMGetUserItemHandler.handle(request);
    }

    @PostMapping(value = {"Mai/CMGetUserPreviewApi"})
    public String maiCMGetUserPreview(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return maiCMGetUserPreviewHandler.handle(request);
    }

    @PostMapping(value = {"Mai/Ping"})
    public String maiPing(@ModelAttribute Map<String, Object> request){
        return "{\"result\":1}";
    }

    @PostMapping(value = {"Mai/CMLoginApi"})
    public String maiCMLogin(@ModelAttribute Map<String, Object> request){
        return "{\"returnCode\":1}";
    }

    @PostMapping(value = {"Mai/CMLogoutApi"})
    public String maiCMLogout(@ModelAttribute Map<String, Object> request){
        return "{\"returnCode\":1}";
    }

    @PostMapping(value = {"Mai/CMUpsertBuyCardApi"})
    public String maiCMUpsertBuyCard(@ModelAttribute Map<String, Object> request){
        return "{\"returnCode\":1}";
    }

    @PostMapping(value = {"Mai/CMUpsertUserPrintApi"})
    public String maiCMUpsertUserPrint(@ModelAttribute Map<String, Object> request){
        return "{\"returnCode\":1,\"orderId\":0,\"serialId\": \"\",\"startDate\":\"2021-12-01 07:00:00.0\",\"endDate\":\"2021-12-31 23:59:59.0\"}";
    }

    @PostMapping(value = {"Mai/CMUpsertUserPrintlogApi"})
    public String maiCMUpsertUserPrintlog(@ModelAttribute Map<String, Object> request){
        return "{\"returnCode\":1,\"orderId\":0,\"serialId\": \"\"}";
    }

    // For Chunithm

    @PostMapping(value = {"Chuni/Ping"})
    public String chuniPing(@ModelAttribute Map<String, Object> request){
        return "{\"result\":1}";
    }

    @PostMapping(value = {"Chuni/GetGameGachaApi"})
    public String chuniGetGameGacha(@ModelAttribute Map<String, Object> request) {
        return "";
    }



}


