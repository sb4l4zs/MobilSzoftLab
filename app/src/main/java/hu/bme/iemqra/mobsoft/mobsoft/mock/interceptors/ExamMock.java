package hu.bme.iemqra.mobsoft.mobsoft.mock.interceptors;

import android.net.Uri;

import hu.bme.iemqra.mobsoft.mobsoft.network.NetworkConfig;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;

public class ExamMock {
	public static Response process(Request request) {
		Uri uri = Uri.parse(request.url().toString());

		String responseString;
		int responseCode;
		Headers headers = request.headers();


		if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "exam/1") && request.method().equals("POST")) {
			responseString = "";
			responseCode = 200;

		/**
		 * Simple Get Example
		 */
			/*
		}else if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "Todos") && request.method().equals("Get")) {
			MemoryRepository memoryRepository = new MemoryRepository();
			memoryRepository.open(null);
			responseString = GsonHelper.getGson().toJson(memoryRepository.getFavourites());
			responseCode = 200;*/
		} else {
			responseString = "ERROR";
			responseCode = 503;
		}

		return MockHelper.makeResponse(request, headers, responseCode, responseString);
	}
}
